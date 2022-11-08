package com.aspose.html.android;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.aspose.html.android.model.ConversionResult;
import com.aspose.html.android.options.ImageConversionOptions;
import com.aspose.html.android.options.PDFConversionOptions;
import com.aspose.html.android.options.XPSConversionOptions;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.File;
import java.nio.file.Paths;

public class ConvertEpubTest extends BaseTest{

    @BeforeAll
    public static void init(){
        inputFile = Configuration.getTestSrcDir() + File.separator + "test.epub";
    }

    @ParameterizedTest(name = "{index} - epub -> {0} : local -> local")
    @ValueSource(strings = { "pdf", "xps", "docx", "jpeg", "bmp", "png", "tiff", "gif" })
    public void convertEpubLocalToLocal(String ext) {

        String outputFile = Configuration.getTestDstDir() + File.separator + "convertEpubLocalToLocal." + ext;

        File f = new File(outputFile);
        if(f.exists()) f.delete();

        ConverterBuilder builder = new ConverterBuilder()
                .fromLocalFile(inputFile)
                .saveToLocal(outputFile);

        ConversionResult result = api.convert(builder);
        File dst = new File(result.getFile());
        assertTrue(dst.exists());
    }

    @ParameterizedTest(name = "{index} - epub -> {0} : local -> storage")
    @ValueSource(strings = { "pdf", "xps", "docx", "jpeg", "bmp", "png", "tiff", "gif" })
    public void convertEpubLocalToStorage(String ext) {

        String outputFile = "LocalToStorageTest" + File.separator + "convertEpubLocalToStorage." + ext;

        File f = new File(outputFile);
        if(f.exists()) f.delete();

        ConverterBuilder builder = new ConverterBuilder()
                .fromLocalFile(inputFile)
                .saveToStorage(outputFile);

        ConversionResult result = api.convert(builder);
        assertTrue(TestHelper.isExist(result.getFile()));
        TestHelper.deleteFile(result.getFile());
    }

    @Test
    public void convertEpubToPdfWithOptions() {

        String outputFile = Configuration.getTestDstDir() + File.separator + "convertEpubToPdfWithOptions.pdf";

        File f = new File(outputFile);
        if(f.exists()) f.delete();

        PDFConversionOptions opt_A5 = new PDFConversionOptions()
                .setWidth(5.8)
                .setHeight(8.3)
                .setTopMargin(0.5)
                .setBottomMargin(0.5)
                .setLeftMargin(0.5)
                .setRightMargin(0.5)
                .setQuality(95);

        ConverterBuilder builder = new ConverterBuilder()
                .fromLocalFile(inputFile)
                .useOptions(opt_A5)
                .saveToLocal(outputFile);

        ConversionResult result = api.convert(builder);
        String target = Paths.get(builder.target.filePath).getParent().toString()
                + "/" + Paths.get(result.getFile()).getFileName().toString();
        File testFile = new File(target);
        assertTrue(testFile.exists());
    }

    @Test
    public void convertEpubToXpsWithOptions() {

        String outputFile = Configuration.getTestDstDir() + File.separator + "convertEpubToXpsWithOptions.xps";

        File f = new File(outputFile);
        if(f.exists()) f.delete();

        XPSConversionOptions opt_A5 = new XPSConversionOptions()
                .setWidth(5.8)
                .setHeight(8.3)
                .setTopMargin(0.5)
                .setBottomMargin(0.5)
                .setLeftMargin(0.5)
                .setRightMargin(0.5);

        ConverterBuilder builder = new ConverterBuilder()
                .fromLocalFile(inputFile)
                .useOptions(opt_A5)
                .saveToLocal(outputFile);

        ConversionResult result = api.convert(builder);
        String target = Paths.get(builder.target.filePath).getParent().toString()
                + "/" + Paths.get(result.getFile()).getFileName().toString();
        File testFile = new File(target);
        assertTrue(testFile.exists());
    }


    @ParameterizedTest(name = "{index} - convert to {0}")
    @ValueSource(strings = { "jpeg", "bmp", "png", "tiff", "gif" })
    public void convertEpubToImageWithOptions(String ext) {

        String outputFile = Configuration.getTestDstDir() + File.separator + "convertEpubToImageWithOptions." + ext;

        File f = new File(outputFile);
        if(f.exists()) f.delete();

        ImageConversionOptions opt = new ImageConversionOptions()
                .setWidth(600)
                .setHeight(900)
                .setTopMargin(20)
                .setBottomMargin(20)
                .setLeftMargin(20)
                .setRightMargin(20);

        ConverterBuilder builder = new ConverterBuilder()
                .fromLocalFile(inputFile)
                .useOptions(opt)
                .saveToLocal(outputFile);

        ConversionResult result = api.convert(builder);
        File testFile = new File(result.getFile());
        assertTrue(testFile.exists());
    }

}
