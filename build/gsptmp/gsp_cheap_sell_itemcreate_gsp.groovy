import grails.plugins.metadata.GrailsPlugin
import org.grails.gsp.compiler.transform.LineNumber
import org.grails.gsp.GroovyPage
import org.grails.web.taglib.*
import org.grails.taglib.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_cheap_sell_itemcreate_gsp extends org.grails.gsp.GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/item/create.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',4,['gsp_sm_xmlClosingForEmptyTag':("/"),'name':("layout"),'content':("main")],-1)
printHtmlPart(1)
invokeTag('set','g',5,['var':("entityName"),'value':(message(code: 'item.label', default: 'Item'))],-1)
printHtmlPart(1)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('message','g',6,['code':("default.create.label"),'args':([entityName])],-1)
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
invokeTag('message','g',17,['code':("default.create.label"),'args':([entityName])],-1)
printHtmlPart(8)
if(true && (flash.message)) {
printHtmlPart(9)
expressionOut.print(flash.message)
printHtmlPart(10)
}
printHtmlPart(11)
createTagBody(2, {->
printHtmlPart(12)
createTagBody(3, {->
printHtmlPart(13)
if(true && (error in org.springframework.validation.FieldError)) {
printHtmlPart(14)
expressionOut.print(error.field)
printHtmlPart(15)
}
printHtmlPart(16)
invokeTag('message','g',24,['error':(error)],-1)
printHtmlPart(17)
})
invokeTag('eachError','g',25,['bean':(this.item),'var':("error")],3)
printHtmlPart(18)
})
invokeTag('hasErrors','g',27,['bean':(this.item)],2)
printHtmlPart(11)
createTagBody(2, {->
printHtmlPart(19)
invokeTag('field','f',30,['bean':("item"),'property':("name")],-1)
printHtmlPart(20)
invokeTag('field','f',31,['bean':("item"),'property':("askingPrice")],-1)
printHtmlPart(20)
invokeTag('field','f',32,['bean':("item"),'property':("negotiable")],-1)
printHtmlPart(20)
invokeTag('field','f',33,['bean':("item"),'property':("shippingOption")],-1)
printHtmlPart(20)
invokeTag('field','f',34,['bean':("item"),'property':("itemCondition")],-1)
printHtmlPart(20)
invokeTag('field','f',35,['bean':("item"),'property':("itemUsage")],-1)
printHtmlPart(20)
invokeTag('field','f',36,['bean':("item"),'property':("description")],-1)
printHtmlPart(20)
invokeTag('field','f',37,['bean':("item"),'property':("weight")],-1)
printHtmlPart(20)
invokeTag('field','f',38,['bean':("item"),'property':("color")],-1)
printHtmlPart(20)
invokeTag('field','f',39,['bean':("item"),'property':("material")],-1)
printHtmlPart(21)
invokeTag('submitButton','g',42,['name':("create"),'class':("save"),'value':(message(code: 'default.button.create.label', default: 'Create'))],-1)
printHtmlPart(22)
})
invokeTag('form','g',44,['resource':(this.item),'method':("POST")],2)
printHtmlPart(23)
})
invokeTag('captureBody','sitemesh',46,[:],1)
printHtmlPart(24)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1573955316000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'none'
public static final String TAGLIB_CODEC = 'none'
}
