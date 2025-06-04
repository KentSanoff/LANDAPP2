package com.kentsanoff.landapp.data.export

import android.content.Context
import android.os.Environment
import com.kentsanoff.landapp.data.db.LandField
import com.itextpdf.kernel.pdf.PdfWriter
import com.itextpdf.kernel.pdf.PdfDocument
import com.itextpdf.layout.Document
import com.itextpdf.layout.element.Paragraph
import java.io.File
import java.io.FileOutputStream

object PdfExporter {

    fun exportFieldsToPdf(context: Context, fields: List<LandField>): File? {
        return try {
            val pdfDir = File(context.getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS), "exports")
            if (!pdfDir.exists()) pdfDir.mkdirs()

            val pdfFile = File(pdfDir, "land_fields_export.pdf")

            val outputStream = FileOutputStream(pdfFile)
            val writer = PdfWriter(outputStream)
            val pdfDoc = PdfDocument(writer)
            val document = Document(pdfDoc)

            document.add(Paragraph("LANDAPP - Flächen Export"))
            document.add(Paragraph("-----------------------------"))

            fields.forEach { field ->
                val fieldText = """
                    Name: ${field.name}
                    Kulturart: ${field.cropType}
                    Datum: ${field.editDate}
                    Notizen: ${field.notes}
                """.trimIndent()
                document.add(Paragraph(fieldText))
                document.add(Paragraph("-----------------------------"))
            }

            document.close()
            pdfFile
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }
}
