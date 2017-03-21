import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Created by shubham.tyagi on 05/03/17.
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class BaseSegments {
    @JsonProperty("included")
    List<Integer> included;

    @JsonProperty("excluded")
    List<Integer> excluded;
}
