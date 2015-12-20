<#assign c=JspTaglibs["http://java.sun.com/jsp/jstl/core"]>
<#assign form=JspTaglibs["http://www.springframework.org/tags/form"]>
<#assign s=JspTaglibs["http://www.springframework.org/tags"]>

<@layout.extends name="base.ftl">
    <@layout.put block="title" type="append">: ${project.name}</@layout.put>
    <@layout.put block="menu.project.active">class="active-menu"</@layout.put>
    <@layout.put block="js_head" type="append">
    <script type="text/javascript" src="<@c.url value="/resources/js/project/show.js" />"></script>
    <script src="http://code.highcharts.com/highcharts.js"></script>
    </@layout.put>

    <@layout.put block="content" type="replace">
    <div class="row">
        <div class="col-md-12">
            <h1 class="page-header">
            ${project.name}
                <small><a href="<@c.url value='/project/edit/${project.id}' />"><i class="fa fa-lg fa-pencil"></i></a>
                </small>
            </h1>

            <ol class="breadcrumb">
                <li><a href="<@c.url value='/projects/' />">Projects</a></li>
                <li class="active">${project.name}</li>
            </ol>
        </div>
    </div>
    <div class="row">
        <div class="col-md-4 col-sm-12 col-xs-12">
            <div class="panel panel-default">
                <div class="panel-heading">
                    Description
                </div>
                <div class="panel-body">
                ${project.description}
                </div>
            </div>

        </div>
        <div class="col-md-4 col-sm-12 col-xs-12">
            <div class="panel panel-default">
                <div class="panel-heading">
                    Services
                </div>
                <div class="panel-body">
                    <#list project.services as service>
                        <div class="list-group-item">
                            <a href="${service.url}">
                                <span class="badge">${service.status}</span> ${service.type}
                            </a>
                            <a href="<@c.url value='/service/edit/${service.id}' />">
                                <i class="fa fa-fw fa-pencil"></i>
                            </a>
                        </div>
                    </#list>
                </div>
                <a href="<@c.url value='/service/create' />">
                    <button type="submit" class="btn btn-default">
                        <i class="fa fa-fw fa-plus"></i>
                    </button>
                </a>
            </div>
        </div>
        <div class="col-md-4 col-sm-12 col-xs-12">
            <div class="panel panel-default">
                <div class="panel-heading">
                    Instances
                </div>
                <div class="panel-body">
                    <div class="list-group">
                        <#list project.instances as instance>
                            <a href="<@c.url value='/instance/show/${instance.id}' />" class="list-group-item">
                                <span class="badge">${instance.status}</span>
                                <span class="badge">${instance.version}</span>
                                <i class="fa fa-fw fa-comment"></i> ${instance.url} ${instance.type}
                            </a>
                        </#list>
                    </div>
                    <a href="<@c.url value='/instance/create' />">
                        <button type="submit" class="btn btn-default">
                            <i class="fa fa-fw fa-plus"></i>
                        </button>
                    </a>
                </div>
            </div>

        </div>
    </div>

    <div class="row">
        <div class="col-md-12 col-sm-12 col-xs-12">
            <div class="panel panel-default">
                <div class="panel-heading">
                    Violations
                </div>
                <div class="panel-body">
                    <div class="list-group">
                        <#list project.instances as instance>
                            <#list instance.violations as violation>
                                <a href="#" class="list-group-item">
                                    <span class="badge">${instance.type}</span>
                                    <i class="fa fa-fw fa-comment"></i>${violation.dateTime} ${violation.message}
                                </a>
                            </#list>
                        </#list>
                    </div>
                </div>
            </div>

        </div>
    </div>
    </@layout.put>
</@layout.extends>
