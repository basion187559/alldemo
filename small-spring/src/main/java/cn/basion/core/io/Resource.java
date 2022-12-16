package cn.basion.core.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * @description:
 * @author: wupeineng
 * @create: 2022-12-11 16:11
 */
public interface Resource {

    InputStream getInputStream() throws IOException;
}
