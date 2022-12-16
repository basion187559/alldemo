package cn.basion.core.io;

import cn.basion.util.ClassUtils;
import cn.hutool.core.lang.Assert;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * @description:
 * @author: wupeineng
 * @create: 2022-12-11 16:11
 */
public class ClassPathResource implements Resource{
    private final String path;
    private ClassLoader classLoader;

    public ClassPathResource(String path) {
        this(path,null);
    }
    public ClassPathResource(String path, ClassLoader classLoader){
        Assert.notNull(path, "Path must not be null");
        this.path = path;
        this.classLoader = classLoader != null ? classLoader : ClassUtils.getDefaultClassLoader();

    }

    @Override
    public InputStream getInputStream() throws IOException {
        InputStream is = classLoader.getResourceAsStream(path);
        if(is == null){
            throw new FileNotFoundException(
                    this.path + " cannot be opened because it does not exist");
        }
        return is;
    }
}
