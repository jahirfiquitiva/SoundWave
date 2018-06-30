package co.soundwave.servlets

import java.io.File
import java.io.FileNotFoundException
import java.io.FileOutputStream
import java.io.InputStream
import java.io.OutputStream
import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
import javax.servlet.http.Part

@WebServlet(name = "UploadServlet", urlPatterns = ["/UploadServlet"])
class UploadServlet : BaseServlet() {
    
    override fun processRequest(
        request: HttpServletRequest,
        response: HttpServletResponse,
        type: Type
                               ) {
        response.contentType = "text/html;charset=UTF-8"
        val path = request.getParameter("destination")
        val filePart = request.getPart("file")
        val fileName = getFileName(filePart)
        var out: OutputStream? = null
        var fileContent: InputStream? = null
        val writer = response.writer
        try {
            out = FileOutputStream(File(path + File.separator + fileName))
            fileContent = filePart.inputStream
            var read = 0
            val bytes = ByteArray(1024)
            while ({ read = fileContent?.read(bytes) ?: -1;read }() != -1) {
                out.write(bytes, 0, read)
            }
            writer?.println("$fileName created at $path")
        } catch (fne: FileNotFoundException) {
            writer?.println("Error in file upload ERROR:" + fne.message)
        } finally {
            out?.close()
            fileContent?.close()
            writer?.close()
        }
    }
    
    private fun getFileName(part: Part): String? {
        val partHeader = part.getHeader("content-disposition")
        for (content in partHeader.split(
            ";".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()) {
            if (content.trim { it <= ' ' }.startsWith("filename")) {
                return content.substring(content.indexOf('=') + 1).trim { it <= ' ' }
                    .replace("\"", "")
            }
        }
        return null
    }
    
    override fun getServletInfo(): String = "Upload Servlet"
}