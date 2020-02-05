package moe.xinmu.patchouli.doggytalents;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandler;
import java.util.Objects;

public class BaseURLStreamHandler extends URLStreamHandler {
    public static final BaseURLStreamHandler INSTANCE = new BaseURLStreamHandler();

    @Override
    protected URLConnection openConnection(URL u) throws IOException {
        String path = u.getFile();
        String className = path.substring(1, path.length() - 6/* ".class".length() */);
        byte[] bytes = Remapper.remapper.transform(className);
        if (Objects.isNull(bytes)) {
            throw new IOException();
        } else {
            return new BaseURLConnection(u, bytes);
        }
    }

    static class BaseURLConnection extends URLConnection {
        byte[] bytes;

        public BaseURLConnection(URL u, byte[] bytes) {
            super(u);
            this.bytes = bytes;
        }

        @Override
        public void connect() {

        }

        @Override
        public InputStream getInputStream() {
            return new ByteArrayInputStream(bytes);
        }
    }
}
