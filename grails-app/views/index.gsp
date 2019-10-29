<!doctype html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Welcome to Grails</title>
</head>
<body>
<content tag="nav">

</content>

<div class="svg" role="presentation">
    <div class="grails-logo-container">
%{--        <asset:image src="grails-cupsonly-logo-white.svg" class="grails-logo"/>--}%
    </div>
</div>

<div id="content" role="main">
    <section class="row colset-2-its">
        <h1>Welcome ${user} to Cheap Sell</h1>

        <p>
            Its a $100 furniture shop. Buy and sell used furniture within $100.
        </p>

        <div id="controllers" role="navigation">
            <h2></h2>
            <ul>
                <g:if test="${role == 'admin'}">
                    <li class="controller">
                        <g:link controller="user" action="index">Users</g:link>
                    </li><li class="controller">
                        <g:link controller="item" action="index">Items</g:link>
                    </li>
                </g:if>
                <g:elseif test="${role == 'buyer'}">
                    <li class="controller">
                        <g:link controller="user" action="edit" id="${id}">Profile</g:link>
                    </li>
                    <li class="controller">
                        <g:link controller="user" action="edit" id="${id}">Profile</g:link>
                    </li>
                </g:elseif>
                <g:elseif test="${role == 'seller'}">
                    <li class="controller">
                        <g:link controller="user" action="edit" id="${id}">Profile</g:link>
                    </li>
                    <li class="controller">
                        <g:link controller="item" action="index">Items</g:link>
                    </li>
                </g:elseif>
                <g:else>
                    Please Register or <a href="/login">Login</a>
                </g:else>
            </ul>
        </div>
    </section>
</div>

</body>
</html>
