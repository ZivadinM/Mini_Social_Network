/** @format */

var postContainter = document.getElementById("posts_container");
var userContainter = document.getElementById("users_container");

function CardAdd(post) {
	return `                    
       <div class="col-md-3 product-card">
								<div class="card">
									<img
										src="https://via.placeholder.com/200x100"
										class="card-img-top"
										alt="Product Image"
									/>
									<div class="card-body text-center">
										<h5 class="card-title">TV Set</h5>
										<p class="card-text">$300</p>
										<div
											class="d-flex justify-content-center align-items-center"
										>
											<input
												type="number"
												class="form-control me-2"
												min="0"
												value="0"
												style="width: 60px"
											/>
											<button class="btn btn-primary">Add To Cart</button>
										</div>
									</div>
								</div>
							</div>`;
}
function UserCardAdd(post) {
	return `                    
        <section class="py-5 bg-light">
                    <div class="row gx-5  justify-content-center">
                        
                            <div class="text-center">
                                <img class="img-fluid rounded-circle mb-4 px-4" src="/assets/${
																	post.ownerPicture
																}" alt="..." />
                                <h5 class="fw-bolder">${
																	post.ownerFirstname + " " + post.ownerLastname
																}</h5>
                                <div class="fst-italic text-muted">${
																	"Godine: " + post.ownerYears
																}</div>
                            </div>
                        </div>
                    
                </div>
            </section>`;
}

function setPostId(postId) {
	localStorage.setItem("post_id", postId);
}

fetch("http://localhost:8082/posts/allwithusers")
	.then((response) => response.json())
	.then((posts) => {
		var postsMarkup = "";
		for (let post of posts) {
			postsMarkup += CardAdd(post);
		}
		postContainter.innerHTML = postsMarkup;

		var usersMarkup = "";
		var postcon = [];
		for (let post of posts) {
			if (!postcon.includes(post.ownerId)) {
				postcon.push(post.ownerId);
				usersMarkup += UserCardAdd(post);
			}
		}
		userContainter.innerHTML = usersMarkup;

		const buttons = document.querySelectorAll(".view_btn");
		buttons.forEach((button) => {
			button.addEventListener("click", function (event) {
				const postId = button.getAttribute("data-id");
				console.log(postId);

				setPostId(postId);
			});
		});
	});
