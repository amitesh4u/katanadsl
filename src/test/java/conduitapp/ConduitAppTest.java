package conduitapp;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.intuit.karate.Results;
import com.intuit.karate.Runner;
import org.junit.jupiter.api.Test;

public class ConduitAppTest {

  @Test
  void testEncodingParallel() {
    Results results = Runner.path("classpath:conduitapp")
        .parallel(2);
    assertEquals(0, results.getFailCount(), results.getErrorMessages());
  }
}
