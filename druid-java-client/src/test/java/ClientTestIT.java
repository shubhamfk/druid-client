import com.shubham.druid.client.DruidClient;
import com.shubham.druid.client.aggregator.DruidAggregator;
import com.shubham.druid.client.aggregator.DruidQueryAggregator;
import com.shubham.druid.client.filter.DruidFilter;
import com.shubham.druid.client.filter.DruidQueryFilter;
import com.shubham.druid.client.representations.DruidQuery;
import org.junit.Test;
import com.fasterxml.jackson.databind.ObjectMapper;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * Created by shubham.tyagi on 21/03/17.
 */
public class ClientTestIT {

    private static final String DIMENSION_SEPARATOR = "sg_";
    private static final String ZONE_FIELD_NAME = "zone_id";

    @Test
    public void testClientIntegration() throws IOException {
        DruidClient client = new DruidClient("http://10.34.121.183:8082/druid/v2/?pretty");
        String request = "{\"segment_groups\":[],\"zones\":[\"83517\", \"83516\", \"84251\", \"83515\", \"84209\"]}";
        ObjectMapper objectMapper = new ObjectMapper();
        DruidQuery query = new DruidQuery.DruidQueryBuilder("at_reach_supply",
                transform(objectMapper.readValue(request, SegmentsReachSupplyRequest.class)),
                Arrays.asList(DruidQueryAggregator.hyperUnique().setFields("Reach", "reach"), DruidQueryAggregator.count().setFields("supply")),
                System.currentTimeMillis() - TimeUnit.DAYS.toMillis(30), System.currentTimeMillis()).setGranularity("all").build();
        System.out.println(client.getResponse(query).readEntity(String.class));
    }

    public static DruidFilter transform(SegmentsReachSupplyRequest request) {
        List<DruidFilter> includeList = null;
        List<DruidFilter> excludeList = null;
        List<DruidFilter> zonesList;
        List<DruidFilter> finalFilterList = new ArrayList<>();

        for(SegmentGroup segmentGroup : request.getSegmentGroups()) {
            String segGroupId = segmentGroup.getId();
            includeList = getFilteredIncludeOrExcludeList(segmentGroup.getBaseSegments().getIncluded(),
                    segGroupId);
            excludeList = getFilteredIncludeOrExcludeList(segmentGroup.getBaseSegments().getExcluded(),
                    segGroupId);
        }

        zonesList = getFilterListZonesList(request.getZones());

        if(includeList != null && !includeList.isEmpty()) finalFilterList.add(DruidQueryFilter.or().addFilterList(includeList));
        if(excludeList != null && !excludeList.isEmpty()) finalFilterList.add(
                DruidQueryFilter.not().addFilter(DruidQueryFilter.or().addFilterList(excludeList)));

        finalFilterList.add(DruidQueryFilter.or().addFilterList(zonesList));

        return DruidQueryFilter.and().addFilterList(finalFilterList);
    }

    static private List<DruidFilter> getFilterListZonesList(List<String> zones) {
        List<DruidFilter> filterList = new ArrayList<>();
        filterList.addAll(zones.stream().map(zone -> DruidQueryFilter.select().setQueryValues(ZONE_FIELD_NAME,
                String.valueOf(zone))).collect(Collectors.toList()));
        return filterList;
    }

    static private List<DruidFilter> getFilteredIncludeOrExcludeList(List<Integer> baseSegments, String segGroupId) {
        List<DruidFilter> filterList = new ArrayList<>();
        String dimension = DIMENSION_SEPARATOR + String.valueOf(segGroupId);
        filterList.addAll(baseSegments.stream().map(segment -> DruidQueryFilter.select().setQueryValues(dimension,
                String.valueOf(segment))).collect(Collectors.toList()));
        return filterList;
    }
}
