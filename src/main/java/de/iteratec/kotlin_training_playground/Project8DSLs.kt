package de.iteratec.kotlin_training_playground

import org.apache.pdfbox.pdmodel.PDDocument
import org.apache.pdfbox.pdmodel.PDPage
import org.apache.pdfbox.pdmodel.PDPageContentStream
import org.apache.pdfbox.pdmodel.font.PDFont
import org.apache.pdfbox.pdmodel.font.PDType1Font.HELVETICA
import java.io.File

data class PdfData(
    val name: String,
    val age: Int,
    val phoneNumber: String = "1111111111"
    // TODO: more properties
)

fun loadTemplate(resourceName: String): PDDocument {
    return PDDocument.load(loadResource(resourceName))
}

private fun loadResource(resourceName: String) = object {}.javaClass.getResourceAsStream(resourceName)

private fun createContentStream(document: PDDocument, page: PDPage): PDPageContentStream {
    return PDPageContentStream(document, page, PDPageContentStream.AppendMode.APPEND, true, true)
}

/**
 * Writes some text at the given position.
 */
fun PDPageContentStream.writeText(
    text: String,
    x: Float = 300f,
    y: Float,
    font: PDFont = HELVETICA,
    fontSize: Float = 14f
) {
    beginText()
    setFont(font, fontSize)
    newLineAtOffset(x, y)
    showText(text)
    endText()
}


/**
 * Loads a template PDF, fills it with the specified data, and saves it to another file.
 */
fun createPdf(
    data: PdfData,
    templateResource: String = "/form.pdf",
    outFile: File = File("form_filled.pdf"),
    firstRowY: Float = 750f,
    rowHeight: Float = 29.2f
) {

    loadTemplate(templateResource).use { document ->
        val page1 = document.getPage(0)
        val page2 = document.getPage(1)

        createContentStream(document, page1).use { contentStream ->
            contentStream.writeText(data.name, y = firstRowY)
            contentStream.writeText(data.age.toString(), y = firstRowY - rowHeight)
            // TODO: add more
        }

        createContentStream(document, page2).use { contentStream ->
            contentStream.writeText(data.phoneNumber, y = firstRowY)
            // TODO: add more
        }

        document.save(outFile)
    }

}


fun main() {
    val data = PdfData(name = "Marc", age = 34)
    createPdf(data)
}

// show contentStream.apply in writeText

// modify writeText into an extension function

// use contentStream.apply again

// create onPage(1)
