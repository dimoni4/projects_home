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
                ${instance.name} <small><a href="<@c.url value='/project/edit/${project.id}' />"><i class="fa fa-lg fa-pencil"></i></a></small>
            </h1>

            <ol class="breadcrumb">
                <li><a href="<@c.url value='/projects/' />">Projects</a></li>
                <li class="active">${project.name}</li>
            </ol>
        </div>
    </div>
    <div class="row">
        <div class="col-md-3 col-sm-12 col-xs-12">
            <div class="panel panel-primary text-center no-boder bg-color-green">
                <div class="panel-left pull-left green">
                    <i class="fa fa-bar-chart-o fa-5x"></i>

                </div>
                <div class="panel-right pull-right">
                    <h3>8,457</h3>
                    <strong> Daily Visits</strong>
                </div>
            </div>
        </div>
        <div class="col-md-3 col-sm-12 col-xs-12">
            <div class="panel panel-primary text-center no-boder bg-color-blue">
                <div class="panel-left pull-left blue">
                    <i class="fa fa-shopping-cart fa-5x"></i>
                </div>

                <div class="panel-right pull-right">
                    <h3>52,160 </h3>
                    <strong> Sales</strong>

                </div>
            </div>
        </div>
        <div class="col-md-3 col-sm-12 col-xs-12">
            <div class="panel panel-primary text-center no-boder bg-color-red">
                <div class="panel-left pull-left red">
                    <i class="fa fa fa-comments fa-5x"></i>

                </div>
                <div class="panel-right pull-right">
                    <h3>15,823 </h3>
                    <strong> Comments </strong>

                </div>
            </div>
        </div>
        <div class="col-md-3 col-sm-12 col-xs-12">
            <div class="panel panel-primary text-center no-boder bg-color-brown">
                <div class="panel-left pull-left brown">
                    <i class="fa fa-users fa-5x"></i>

                </div>
                <div class="panel-right pull-right">
                    <h3>36,752 </h3>
                    <strong>No. of Visits</strong>

                </div>
            </div>
        </div>
    </div>

    <div class="row">
        <div class="col-md-6 col-sm-12 col-xs-12">
            <div class="panel panel-default">
                <div class="panel-heading">
                    Instances
                </div>
                <div class="panel-body">
                    <div class="list-group">
                        <#list project.instances as instance>
                            <a href="#" class="list-group-item">
                                <span class="badge">${instance.status}</span>
                                <span class="badge">${instance.version}</span>
                                <i class="fa fa-fw fa-comment"></i> ${instance.url} ${instance.type}
                            </a>
                        </#list>
                    </div>
                </div>
            </div>

        </div>
        <div class="col-md-6 col-sm-12 col-xs-12">
            <div class="panel panel-default">
                <div class="panel-heading">
                    Description
                </div>
                <div class="panel-body">
                ${project.description}
                </div>
            </div>

        </div>
    </div>

    <div class="row">
        <div class="col-md-6 col-sm-12 col-xs-12">
            <div class="panel panel-default">
                <div class="panel-heading">
                    Tasks Panel
                </div>
                <div class="panel-body">

                </div>
            </div>

        </div>
        <div class="col-md-6 col-sm-12 col-xs-12">
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
