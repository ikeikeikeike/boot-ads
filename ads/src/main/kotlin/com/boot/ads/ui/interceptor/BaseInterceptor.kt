package com.boot.ads.ui.interceptor

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.method.HandlerMethod
import org.springframework.web.servlet.ModelAndView
import org.springframework.web.servlet.config.annotation.InterceptorRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class BaseInterceptor : HandlerInterceptorAdapter() {

    @Throws(Exception::class)
    override fun postHandle(request: HttpServletRequest, response: HttpServletResponse, handler: Any, modelAndView: ModelAndView?){
        if (modelAndView === null) {
            return
        }

        var controllerName = ""
        var actionName = ""

        if (handler is HandlerMethod) {
            // there are cases where this handler isn't an instance of HandlerMethod, so the cast fails.
            val handlerMethod = handler as HandlerMethod?
            //controllerName = handlerMethod.getBean().getClass().getSimpleName().replace("Controller", "");
            controllerName = handlerMethod!!.beanType.simpleName.replace("Controller", "")
            actionName = handlerMethod.method.name
        }

        modelAndView.addObject("controllerName", controllerName)
        modelAndView.addObject("actionName", actionName)
    }
}

@Configuration
class BaseConfig: WebMvcConfigurer {

    @Bean
    fun baseInterceptor(): BaseInterceptor {
        return BaseInterceptor()
    }

    override fun addInterceptors(registry: InterceptorRegistry) {
        registry.addInterceptor(baseInterceptor())
    }

}
