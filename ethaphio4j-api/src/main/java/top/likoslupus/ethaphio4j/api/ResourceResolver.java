package top.likoslupus.ethaphio4j.api;

import java.io.IOException;
import java.io.InputStream;

public interface ResourceResolver {

    InputStream open(String uri) throws IOException;

}
