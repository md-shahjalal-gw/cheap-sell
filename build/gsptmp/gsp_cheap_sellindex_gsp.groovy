import grails.plugins.metadata.GrailsPlugin
import org.grails.gsp.compiler.transform.LineNumber
import org.grails.gsp.GroovyPage
import org.grails.web.taglib.*
import org.grails.taglib.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_cheap_sellindex_gsp extends org.grails.gsp.GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/index.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',4,['gsp_sm_xmlClosingForEmptyTag':("/"),'name':("layout"),'content':("main")],-1)
printHtmlPart(1)
createTagBody(2, {->
createClosureForHtmlPart(2, 3)
invokeTag('captureTitle','sitemesh',5,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',5,[:],2)
printHtmlPart(3)
})
invokeTag('captureHead','sitemesh',6,[:],1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(3)
createClosureForHtmlPart(4, 2)
invokeTag('captureContent','sitemesh',10,['tag':("nav")],2)
printHtmlPart(5)
expressionOut.print(user)
printHtmlPart(6)
if(true && (role == 'admin')) {
printHtmlPart(7)
createClosureForHtmlPart(8, 3)
invokeTag('link','g',30,['controller':("user"),'action':("index")],3)
printHtmlPart(9)
createClosureForHtmlPart(10, 3)
invokeTag('link','g',31,['controller':("item"),'action':("index")],3)
printHtmlPart(11)
}
else if(true && (role == 'buyer')) {
printHtmlPart(7)
createClosureForHtmlPart(12, 3)
invokeTag('link','g',36,['controller':("user"),'action':("edit"),'id':(id)],3)
printHtmlPart(9)
createClosureForHtmlPart(10, 3)
invokeTag('link','g',37,['controller':("item"),'action':("index")],3)
printHtmlPart(11)
}
else if(true && (role == 'seller')) {
printHtmlPart(7)
createClosureForHtmlPart(12, 3)
invokeTag('link','g',42,['controller':("user"),'action':("edit"),'id':(id)],3)
printHtmlPart(9)
createClosureForHtmlPart(10, 3)
invokeTag('link','g',43,['controller':("item"),'action':("index")],3)
printHtmlPart(11)
}
else {
printHtmlPart(13)
}
printHtmlPart(14)
})
invokeTag('captureBody','sitemesh',49,[:],1)
printHtmlPart(15)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1572312472000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'none'
public static final String TAGLIB_CODEC = 'none'
}
