package com.xworkz.techroute.util;

import com.openhtmltopdf.pdfboxout.PdfRendererBuilder;
import lombok.extern.slf4j.Slf4j;

import java.io.ByteArrayOutputStream;

@Slf4j
public class PdfGenerator {

    private PdfGenerator(){
        log.info("PdfGenerator created");
    }

    public static byte[] htmlToPdf(String html) {
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            PdfRendererBuilder builder = new PdfRendererBuilder();
            builder.useFastMode();
            builder.withHtmlContent(html, null);
            builder.toStream(baos);
            builder.run();
            return baos.toByteArray();
        } catch (Exception e) {
            throw new IllegalStateException("Failed to generate PDF", e);
        }
    }
}
