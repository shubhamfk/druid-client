import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Created by shubham.tyagi on 05/03/17.
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SegmentGroup {
    @JsonProperty("id")
    String id;

    @JsonProperty("base_segments")
    BaseSegments baseSegments;
}
