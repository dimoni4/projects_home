<#assign c=JspTaglibs["http://java.sun.com/jsp/jstl/core"]>
<#assign form=JspTaglibs["http://www.springframework.org/tags/form"]>
<#assign s=JspTaglibs["http://www.springframework.org/tags"]>


<@layout.extends name="base.ftl">
    <@layout.put block="body" type="replace">
    <div class="row">
        <div class="col-lg-12">
            <div class="panel panel-default">
                <div class="panel-heading">
                    Login
                </div>
                <div class="panel-body">
                    <div class="row">
                        <div class="col-lg-6">
                            <form role="form" action="<@c.url value='/login' />" method="POST">
                                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                                <div class="form-group">
                                    <input id="username" type="email" name="username" class="form-control" placeholder="Email">
                                </div>
                                <div class="form-group">
                                    <input  id="password" type="password" name="password"  class="form-control" placeholder="Password">
                                </div>

                                <button type="submit" class="btn btn-default">Login</button>
                            </form>
                        </div>
                    </div>
                    <!-- /.row (nested) -->
                </div>
                <!-- /.panel-body -->
            </div>
            <!-- /.panel -->
        </div>
        <!-- /.col-lg-12 -->
    </div>
    </@layout.put>
</@layout.extends>
