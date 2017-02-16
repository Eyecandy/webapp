<div id="openModal" class="modalDialog">
    <div>
        <h2>Remove User</h2>
        <p>${msg}</p>
         <form action="/removeUser" method="post">
             <input type="submit" name="buttonClicked" value="Yes">

             <input type="hidden" name="username" value="${username}">
            <input type="submit" name="buttonClicked" value="No">

        </form>



    </div>
</div>