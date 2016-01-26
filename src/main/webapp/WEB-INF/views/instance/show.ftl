<#assign c=JspTaglibs["http://java.sun.com/jsp/jstl/core"]>
<#assign form=JspTaglibs["http://www.springframework.org/tags/form"]>
<#assign s=JspTaglibs["http://www.springframework.org/tags"]>

<@layout.extends name="base.ftl">
    <@layout.put block="title" type="append">: ${instance.project.name}: ${instance.url}</@layout.put>
    <@layout.put block="menu.project.active">class="active-menu"</@layout.put>
    <@layout.put block="js_head" type="append">
    <script type="text/javascript" src="<@c.url value="/resources/js/project/show.js" />"></script>
    <script src="http://code.highcharts.com/highcharts.js"></script>
    </@layout.put>

    <@layout.put block="content" type="replace">
    <div class="row">
        <div class="col-md-12">
            <h1 class="page-header">
                ${instance.url}
                    <small>
                        <a href="<@c.url value='/project/${instance.project.id}/instance/${instance.id}/edit' />">
                            <i class="fa fa-lg fa-pencil"></i>
                        </a>
                    </small>
            </h1>

            <ol class="breadcrumb">
                <li><a href="<@c.url value='/project/all/' />">Projects</a></li>
                <li><a href="<@c.url value='/project/${instance.project.id}' />">${instance.project.name}</a></li>
                <li class="active">${instance.url}</li>
            </ol>
        </div>
    </div>

    <div class="row">
        <div class="col-md-6 col-sm-12 col-xs-12">
            <div class="panel panel-default">
                <div class="panel-heading">
                    Info
                </div>
                <div class="panel-body">
                    ${instance.type}
                    ${instance.checkCreteria.type}
                    ${instance.checkCreteria.checkWord}
                </div>
            </div>

        </div>
    </div>
    </@layout.put>
</@layout.extends>
