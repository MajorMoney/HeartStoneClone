package Utils;

import java.io.File;

public class ResourceUtils {

  public static final String BASE_PATH = "src/main/resources/";

  public static File getFileFromResources(String fileName) {
    return new File(BASE_PATH.concat(fileName));
  }
}
