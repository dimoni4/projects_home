<#assign c=JspTaglibs["http://java.sun.com/jsp/jstl/core"] />
<#assign fn=JspTaglibs["http://java.sun.com/jsp/jstl/functions"] />
<#assign s=JspTaglibs["http://www.springframework.org/tags"] />
<#assign form=JspTaglibs["http://www.springframework.org/tags/form"] />
<!DOCTYPE html>
<html>
<head>
    <title><@layout.block name="title">Projects Home</@layout.block></title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
<#--<meta content="Платежный сервис, который позволяет совершать моментальные платежи с помощью мобильного телефона, интернета и платежных карт Visa, MasterCard во всём мире. Сервис моментальных платежей Liqpay создан Приват Банком и заверен сертификатами GoDaddy Secure Web Site, Verified by Visa и MasterCard SecureCode. Платежный сервис Liqpay - будущее электронной коммерции." name="description">-->
<#--<meta content="платежные системы, платежная система, система моментальных платежей, моментальные платежи" name="keywords">-->
<#--<link rel="shortcut icon" href="<@c.url value="/img/favicon.ico" />" type="image/x-icon">-->
    <script type="text/javascript">
        var $applicationRoot = "<@s.url value="/" />";
        var $host = document.location.protocol + '//' + document.location.host;
        var $hostRoot = document.location.protocol + '//' + document.location.host + $applicationRoot;
        var $resourcesRoot = "<@c.url value="/resources/" />";
    </script>

<@layout.block name="css_head">
    <link type="text/css" rel="stylesheet" href="<@c.url value="/resources/css/materialize.min.css" />"
          media="screen,projection"/>
    <link type="text/css" rel="stylesheet" href="<@c.url value="/resources/css/main.css" />" media="screen,projection"/>
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
</@layout.block>

<@layout.block name="js_head">
    <script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
    <script type="text/javascript" src="<@c.url value="/resources/js/spin.js" />"></script>
    <script type="text/javascript" src="<@c.url value="/resources/js/materialize.min.js" />"></script>
    <script type="text/javascript" src="<@c.url value="/resources/js/app.js" />"></script>
    <!--[if lt IE 9]>
    <script src="https://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->
</@layout.block>
</head>
<body>
<@layout.block name="body">
<header>
    <@layout.block name="menu"></@layout.block>
</header>
<main>
    <@layout.block name="content"></@layout.block>
</main>
</@layout.block>
</body>
</html>