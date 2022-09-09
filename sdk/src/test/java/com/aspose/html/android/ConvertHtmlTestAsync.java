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
import java.util.concurrent.CompletableFuture;

public class ConvertHtmlTestAsync extends BaseTest{

    @BeforeAll
    public static void init(){
        inputFile = Configuration.getTestSrcDir() + File.separator + "test1.html";
        inputUrl = "https://stallman.org/articles/anonymous-payments-thru-phones.html";
    }

    @ParameterizedTest(name = "{index} - html -> {0} : local -> local async")
    @ValueSource(strings = { "pdf", "xps", "docx", "md", "mhtml", "jpeg", "bmp", "png", "tiff", "gif" })
    public void convertHtmlLocalToLocalAsync(String ext) {

        String outputFile = Configuration.getTestDstDir() + File.separator + "testAsync." + ext;

        File f = new File(outputFile);
        if(f.exists()) f.delete();

        ConverterBuilder builder = new ConverterBuilder()
                .fromLocalFile(inputFile)
                .saveToLocal(outputFile);

        CompletableFuture<ConversionResult>
                cf = CompletableFuture.supplyAsync(() -> api.convert(builder));

        cf.whenComplete((result, err) -> {
           if(err == null){
               File dst = new File(result.getFile());
               assertTrue(dst.exists());
           } else {
               throw new RuntimeException(err.getMessage());
           }
        });

        waitForDone(cf);

    }

    @ParameterizedTest(name = "{index} - html -> {0} : local -> storage async")
    @ValueSource(strings = { "pdf", "xps", "docx", "md", "mhtml", "jpeg", "bmp", "png", "tiff", "gif" })
    public void convertHtmlLocalToStorageAsync(String ext) {

        String outputFile = "LocalToStorageTest" + File.separator + "testAsync." + ext;

        File f = new File(outputFile);
        if(f.exists()) f.delete();

        ConverterBuilder builder = new ConverterBuilder()
                .fromLocalFile(inputFile)
                .saveToStorage(outputFile);

        CompletableFuture<ConversionResult>
                cf = CompletableFuture.supplyAsync(() -> api.convert(builder));

        cf.whenComplete((result, err) -> {
            assertTrue(TestHelper.isExist(result.getFile()));
            TestHelper.deleteFile(result.getFile());
        });

        waitForDone(cf);
    }

    @ParameterizedTest(name = "{index} - url -> {0} : save to local async")
    @ValueSource(strings = { "pdf", "xps", "docx", "md", "mhtml", "jpeg", "bmp", "png", "tiff", "gif" })
    public void convertUrlToLocalAsync(String ext) {

        String outputFile = Configuration.getTestDstDir() + File.separator + "testAsync." + ext;

        File f = new File(outputFile);
        if(f.exists()) f.delete();

        ConverterBuilder builder = new ConverterBuilder()
                .fromUrl(inputUrl)
                .saveToLocal(outputFile);

        CompletableFuture<ConversionResult>
                cf = CompletableFuture.supplyAsync(() -> api.convert(builder));

        cf.whenComplete((result, err) -> {
            File dst = new File(result.getFile());
            assertTrue(dst.exists());
        });
        waitForDone(cf);
    }

    @ParameterizedTest(name = "{index} - url -> {0} : save to storage async")
    @ValueSource(strings = { "pdf", "xps", "docx", "md", "mhtml", "jpeg", "bmp", "png", "tiff", "gif" })
    public void convertUrlToStorageAsync(String ext) {

        String outputFile = "UrlToStorageTest" + File.separator + "testAsync." + ext;

        File f = new File(outputFile);
        if(f.exists()) f.delete();

        ConverterBuilder builder = new ConverterBuilder()
                .fromUrl(inputUrl)
                .saveToStorage(outputFile);

        CompletableFuture<ConversionResult>
                cf = CompletableFuture.supplyAsync(() -> api.convert(builder));

        cf.whenComplete((result, err) -> {
            String ff = result.getFile();
            assertTrue(TestHelper.isExist(ff));
            TestHelper.deleteFile(ff);
        });
        waitForDone(cf);
    }

    @Test
    public void convertHtmlToPdfWithOptionsAsync() {

        String outputFile = Configuration.getTestDstDir() + File.separator + "testWithOptAsync.pdf";

        File f = new File(outputFile);
        if(f.exists()) f.delete();

        PDFConversionOptions opt = new PDFConversionOptions()
                .setWidth(600)
                .setHeight(900)
                .setTopMargin(20)
                .setBottomMargin(20)
                .setLeftMargin(20)
                .setRightMargin(20)
                .setQuality(95);

        ConverterBuilder builder = new ConverterBuilder()
                .fromLocalFile(inputFile)
                .useOptions(opt)
                .saveToLocal(outputFile);

        CompletableFuture<ConversionResult>
                cf = CompletableFuture.supplyAsync(() -> api.convert(builder));

        cf.whenComplete((result, err) -> {
            String target = Paths.get(builder.target.filePath).getParent().toString()
                    + "/" + Paths.get(result.getFile()).getFileName().toString();
            File testFile = new File(target);
            assertTrue(testFile.exists());
        });
        waitForDone(cf);
    }

    @Test
    public void convertHtmlToXpsWithOptions() {

        String outputFile = Configuration.getTestDstDir() + File.separator + "testWithOptAsync.xps";

        File f = new File(outputFile);
        if(f.exists()) f.delete();

        XPSConversionOptions opt = new XPSConversionOptions()
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

        CompletableFuture<ConversionResult>
                cf = CompletableFuture.supplyAsync(() -> api.convert(builder));

        cf.whenComplete((result, err) -> {
            String target = Paths.get(builder.target.filePath).getParent().toString()
                    + "/" + Paths.get(result.getFile()).getFileName().toString();
            File testFile = new File(target);
            assertTrue(testFile.exists());
        });
        waitForDone(cf);
    }


    @ParameterizedTest(name = "{index} - convert to {0}")
    @ValueSource(strings = { "jpeg", "bmp", "png", "tiff", "gif" })
    public void convertHtmlToImageWithOptionsAsync(String ext) {

        String outputFile = Configuration.getTestDstDir() + File.separator + "testWithOptAsync." + ext;

        File f = new File(outputFile);
        if(f.exists()) f.delete();

        ImageConversionOptions opt = new ImageConversionOptions()
                .setWidth(600)
                .setHeight(900)
                .setTopMargin(20)
                .setBottomMargin(20)
                .setLeftMargin(20)
                .setRightMargin(20)
                .setResolution(300);

        ConverterBuilder builder = new ConverterBuilder()
                .fromLocalFile(inputFile)
                .useOptions(opt)
                .saveToLocal(outputFile);

        CompletableFuture<ConversionResult>
                cf = CompletableFuture.supplyAsync(() -> api.convert(builder));
        cf.whenComplete((result, err) -> {
            String target = Paths.get(builder.target.filePath).getParent().toString()
                    + "/" + Paths.get(result.getFile()).getFileName().toString();
            File testFile = new File(target);
            assertTrue(testFile.exists());
        });
        waitForDone(cf);
    }

    private void waitForDone(CompletableFuture<ConversionResult> cf) {
        while (!cf.isDone()) {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                assertTrue(false);
            }
        }
    }

}
