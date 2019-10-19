import grails.plugins.metadata.GrailsPlugin
import org.grails.gsp.compiler.transform.LineNumber
import org.grails.gsp.GroovyPage
import org.grails.web.taglib.*
import org.grails.taglib.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_cheap_sell_contactshow_gsp extends org.grails.gsp.GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/contact/show.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',4,['gsp_sm_xmlClosingForEmptyTag':("/"),'name':("layout"),'content':("main")],-1)
printHtmlPart(1)
invokeTag('set','g',5,['var':("entityName"),'value':(message(code: 'contact.label', default: 'Contact'))],-1)
printHtmlPart(1)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('message','g',6,['code':("default.show.label"),'args':([entityName])],-1)
})
invokeTag('captureTitle','sitemesh',6,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',6,[:],2)
printHtmlPart(2)
})
invokeTag('captureHead','sitemesh',7,[:],1)
printHtmlPart(2)
createTagBody(1, {->
printHtmlPart(3)
invokeTag('message','g',9,['code':("default.link.skip.label"),'default':("Skip to content&hellip;")],-1)
printHtmlPart(4)
expressionOut.print(createLink(uri: '/'))
printHtmlPart(5)
invokeTag('message','g',12,['code':("default.home.label")],-1)
printHtmlPart(6)
createTagBody(2, {->
invokeTag('message','g',13,['code':("default.list.label"),'args':([entityName])],-1)
})
invokeTag('link','g',13,['class':("list"),'action':("index")],2)
printHtmlPart(7)
createTagBody(2, {->
invokeTag('message','g',14,['code':("default.new.label"),'args':([entityName])],-1)
})
invokeTag('link','g',14,['class':("create"),'action':("create")],2)
printHtmlPart(8)
invokeTag('message','g',18,['code':("default.show.label"),'args':([entityName])],-1)
printHtmlPart(9)
if(true && (flash.message)) {
printHtmlPart(10)
expressionOut.print(flash.message)
printHtmlPart(11)
}
printHtmlPart(12)
invokeTag('display','f',22,['bean':("contact")],-1)
printHtmlPart(12)
createTagBody(2, {->
printHtmlPart(13)
createTagBody(3, {->
invokeTag('message','g',25,['code':("default.button.edit.label"),'default':("Edit")],-1)
})
invokeTag('link','g',25,['class':("edit"),'action':("edit"),'resource':(this.contact)],3)
printHtmlPart(14)
expressionOut.print(message(code: 'default.button.delete.label', default: 'Delete'))
printHtmlPart(15)
expressionOut.print(message(code: 'default.button.delete.confirm.message', default: 'Are you sure?'))
printHtmlPart(16)
})
invokeTag('form','g',28,['resource':(this.contact),'method':("DELETE")],2)
printHtmlPart(17)
})
invokeTag('captureBody','sitemesh',30,[:],1)
printHtmlPart(18)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1571515629000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'none'
public static final String TAGLIB_CODEC = 'none'
}
