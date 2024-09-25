package com.teste.criativa.product;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class BarcodeReader {
    public static String readBarcode(String filePath) throws Exception {
        BufferedImage bufferedImage = ImageIO.read(new File(filePath));
        BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(
                new BufferedImageLuminanceSource(bufferedImage)));

        Result result = new MultiFormatReader().decode(bitmap);
        return result.getText();
    }
}

