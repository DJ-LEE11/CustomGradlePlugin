package com.example.asmplugin.basetransfrom.asm;

import java.io.IOException;
import java.io.InputStream;

public interface IModify {

    /**
     * Check a certain file is weavable
     * @param filePath class路径
     * @return 是否需要修改字节码
     */
    public boolean isModifyClass(String filePath) throws IOException;

    /**
     * Weave single class to byte array
     * @param inputStream
     */
    public byte[] modifySingleClassToByteArray(InputStream inputStream) throws IOException;


}

