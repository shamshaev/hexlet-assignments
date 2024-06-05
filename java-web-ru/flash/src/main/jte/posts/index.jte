@import exercise.dto.posts.PostsPage
@import exercise.util.NamedRoutes
@param PostsPage page


@template.layout.page(
page = page,
content = @`
    <div style="text-align: center; height: 600px; overflow: auto;">
        <form action="${NamedRoutes.buildPostPath()}" method="get">
            <input type="submit" value="Добавить пост" />
        </form>
        @for(var post : page.getPosts())
            <div>
                <p style="font-size: 20;">
                    ${post.getId()}   ${post.getName()}   ${post.getBody()}
                </p>
            </div>
        @endfor
    </div>
`
)
