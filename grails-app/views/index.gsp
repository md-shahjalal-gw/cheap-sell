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

        <div id="controllers" role="navigation">
            <h2></h2>
            <ul>
                <g:if test="${role == 'admin'}">
                    <li class="controller">
                        <g:link controller="user" action="index">Users</g:link>
                    </li><li class="controller">
                        <g:link controller="item" action="index">Items List</g:link>
                    </li>
                </g:if>
                <g:elseif test="${role == 'user'}">
                    <li class="controller">
                        <g:if test="${userProfile != ''}">
                            <g:link controller="user" action="edit" id="${userId}">Profile</g:link>
                        </g:if>
                        <g:else>
                            <g:link controller="user" action="create">Profile</g:link>
                        </g:else>
                    </li>
                    <li class="controller">
                        <g:if test="${userProfile == 'BUYER'}">
                            <g:link controller="item" action="index">Buy Item</g:link>
                        </g:if>
                        <g:elseif test="${userProfile == 'SELLER'}">
                            <g:link controller="item" action="create">Sell Item</g:link>
                    </li>
                    <li class="controller">
                            <g:link controller="item" action="index">Update Item</g:link>
                        </g:elseif>
                    </li>
                </g:elseif>
                <g:else>
                    Please <a href="/register/register">Register</a> or <a href="/login">Login</a>
                </g:else>
            </ul>
        </div>
    </section>
</div>

</body>
</html>
