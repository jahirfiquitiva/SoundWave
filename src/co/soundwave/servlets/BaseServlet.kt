package co.soundwave.servlets

import co.soundwave.extensions.ignore
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

abstract class BaseServlet : HttpServlet() {
    
    abstract fun processRequest(
        request: HttpServletRequest,
        response: HttpServletResponse,
        type: Type
                               )
    
    override fun doPost(req: HttpServletRequest?, resp: HttpServletResponse?) {
        req ?: return
        resp ?: return
        ignore { processRequest(req, resp, Type.POST) }
    }
    
    override fun doGet(req: HttpServletRequest?, resp: HttpServletResponse?) {
        req ?: return
        resp ?: return
        ignore { processRequest(req, resp, Type.GET) }
    }
    
    override fun doHead(req: HttpServletRequest?, resp: HttpServletResponse?) {
        req ?: return
        resp ?: return
        ignore { processRequest(req, resp, Type.HEAD) }
    }
    
    override fun doDelete(req: HttpServletRequest?, resp: HttpServletResponse?) {
        req ?: return
        resp ?: return
        ignore { processRequest(req, resp, Type.DELETE) }
    }
    
    override fun doOptions(req: HttpServletRequest?, resp: HttpServletResponse?) {
        req ?: return
        resp ?: return
        ignore { processRequest(req, resp, Type.OPTIONS) }
    }
    
    override fun doPut(req: HttpServletRequest?, resp: HttpServletResponse?) {
        req ?: return
        resp ?: return
        ignore { processRequest(req, resp, Type.PUT) }
    }
    
    override fun doTrace(req: HttpServletRequest?, resp: HttpServletResponse?) {
        req ?: return
        resp ?: return
        ignore { processRequest(req, resp, Type.TRACE) }
    }
    
    enum class Type {
        POST, GET, UPLOAD, DELETE, HEAD, OPTIONS, PUT, TRACE
    }
}