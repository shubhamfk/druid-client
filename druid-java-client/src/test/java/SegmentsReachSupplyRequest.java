import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Created by shubham.tyagi on 05/03/17.
 */
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SegmentsReachSupplyRequest {
    @JsonProperty("segment_groups")
    List<SegmentGroup> segmentGroups;

    @JsonProperty("zones")
    List<String> zones;
}
