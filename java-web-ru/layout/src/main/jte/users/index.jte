@import exercise.dto.users.UsersPage
@param UsersPage page

@template.layout.page(
content = @`
    <div style="height: 600px; overflow: auto;">
        @for(var user : page.getUsers())
            <div>
                <p style="font-size: 20;">
                    <a href="/users/${user.getId()}">${user.getFirstName()} ${user.getLastName()}</a>
                </p>
            </div>
        @endfor
    </div>
`
)
