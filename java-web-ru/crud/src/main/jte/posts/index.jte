@import exercise.dto.posts.PostsPage
@import exercise.util.NamedRoutes;
@param PostsPage postsPage

@template.layout.page(
content = @`
    <div style="text-align: center; height: 600px; overflow: auto;">
        @for(var post : postsPage.getPosts())
            <div>
                <p style="font-size: 20;">
                    <a href="${NamedRoutes.postPath(post.getId())}">${post.getName()}</a>
                </p>
            </div>
        @endfor
        <a href="${NamedRoutes.postsPathWithPage(postsPage.getPage() - 1)}">назад</a>
        <a> -${postsPage.getPage()}- </a>
        <a href="${NamedRoutes.postsPathWithPage(postsPage.getPage() + 1)}">вперед</a>
    </div>
`
)
