package com.wildlivebot.utils

import java.awt.AlphaComposite
import java.awt.RenderingHints
import java.awt.image.BufferedImage
import java.io.ByteArrayOutputStream
import java.io.InputStream
import java.util.Locale
import javax.imageio.IIOImage
import javax.imageio.ImageIO
import javax.imageio.ImageWriteParam
import javax.imageio.ImageWriter

object ImageUtils {

    fun compressImage(
        inputStream: InputStream,
        imagePath: String,
        maxDimension: Int = 1200,
        quality: Float = 0.8f
    ): ByteArray {
        val originalImage = ImageIO.read(inputStream) ?: return byteArrayOf()

        var targetWidth = originalImage.width
        var targetHeight = originalImage.height

        if (targetWidth > maxDimension || targetHeight > maxDimension) {
            if (targetWidth > targetHeight) {
                targetHeight = (maxDimension * targetHeight) / targetWidth
                targetWidth = maxDimension
            } else {
                targetWidth = (maxDimension * targetWidth) / targetHeight
                targetHeight = maxDimension
            }
        }

        val pathLower = imagePath.lowercase(Locale.ROOT)

        val format = when {
            pathLower.endsWith(".png") -> "png"
            pathLower.endsWith(".jpg") || pathLower.endsWith(".jpeg") || pathLower.endsWith(".jpe") -> "jpeg"
            else -> "jpeg"
        }

        val imageType = if (format == "png") BufferedImage.TYPE_INT_ARGB else BufferedImage.TYPE_INT_RGB
        val resizedImage = BufferedImage(targetWidth, targetHeight, imageType)

        val graphics = resizedImage.createGraphics()

        graphics.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC)
        graphics.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY)
        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON)

        graphics.composite = AlphaComposite.Src
        graphics.drawImage(originalImage, 0, 0, targetWidth, targetHeight, null)
        graphics.dispose()

        val outputStream = ByteArrayOutputStream()
        val imageWriters = ImageIO.getImageWritersByFormatName(format)

        if (!imageWriters.hasNext()) {
            ImageIO.write(resizedImage, format, outputStream)
            return outputStream.toByteArray()
        }

        val writer = imageWriters.next() as ImageWriter
        val imageOutputStream = ImageIO.createImageOutputStream(outputStream)
        writer.output = imageOutputStream

        val param = writer.defaultWriteParam

        if (param.canWriteCompressed()) {
            param.compressionMode = ImageWriteParam.MODE_EXPLICIT
            param.compressionQuality = quality
        }

        writer.write(null, IIOImage(resizedImage, null, null), param)
        writer.dispose()
        imageOutputStream.close()

        return outputStream.toByteArray()
    }
}