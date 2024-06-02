@import exercise.dto.posts.PostPage
@import exercise.util.NamedRoutes;
@param PostPage page

@template.layout.page(
content = @`
    <div style="text-align: center; height: 600px; overflow: auto;">
        <h2>${page.getPost().getId()} ${page.getPost().getName()} </h2>
        <p style="font-size: 20px;">${page.getPost().getBody()}</p>
        <a href="${NamedRoutes.postsPath()}">Все посты</a>
    </div>


`
)
