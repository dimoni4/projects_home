<#assign c=JspTaglibs["http://java.sun.com/jsp/jstl/core"]>
<#assign form=JspTaglibs["http://www.springframework.org/tags/form"]>
<#assign s=JspTaglibs["http://www.springframework.org/tags"]>


<@layout.extends name="base.ftl">
    <@layout.put block="body" type="replace">
    <div class="row">
        <form class="col offset-m4 m4" action="<@c.url value='/login' />" method="POST">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

            <div class="row">
                <div class="input-field">
                    <input id="username" type="email" name="username" class="validate">
                    <label for="username">Email</label>
                </div>
            </div>
            <div class="row">
                <div class="input-field">
                    <input id="password" type="password" name="password" class="validate">
                    <label for="password">Password</label>
                </div>
            </div>
            <button class="btn waves-effect waves-light blue-grey lighten-1" type="submit" name="action">Enter
                <i class="mdi-content-send right"></i>
            </button>
        </form>
    </div>
    </@layout.put>
</@layout.extends>
