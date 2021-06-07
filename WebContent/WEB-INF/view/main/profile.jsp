
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/header.jspf"%>

<!-- Main Container Starts -->
<div class="main-container container">
	<!-- Nested Row Starts -->
	<div class="row">
		<!-- Mainarea Starts -->
		<div class="col-md-9 col-sm-12">
			<!-- Menu Tabs Starts -->
			<div class="menu-tabs-wrap">
				<!-- Menu Tabs List Starts -->
				<ul
					class="nav nav-tabs nav-menu-tabs text-xs-center text-sm-center text-md-left">
					<li class="nav-item"><a href="#menu" class="nav-link active"
						data-toggle="tab">개인정보</a></li>
					<li class="nav-item"><a href="#information" class="nav-link"
						data-toggle="tab">내가쓴 댓글</a></li>
					<li class="nav-item"><a href="#gallery" class="nav-link"
						data-toggle="tab">즐겨찾기</a></li>
				</ul>
				<!-- Menu Tabs List Ends -->
				<!-- Menu Tabs Content Starts -->
				<div class="tab-content">
					<!-- Tab #1 Starts -->
					<div id="menu" class="tab-pane fade show active">
						<!-- Tab #1 Nested Row Starts -->
						<div class="row">
							<!-- Left Column Starts -->
							<div class="col-md-12 col-sm-20">
								<section class="registration-area">
									<div class="row">
										<div class="col-sm-8">
											<!-- Registration Block Starts -->
											<div class="panel panel-smart">
												<div class="panel-heading">
													<h3 class="panel-title">Personal Information</h3>
												</div>
												<div class="panel-body">
													<!-- Registration Form Starts -->
													<form class="form-horizontal" action="profile.do"
														method="post">
														<!-- Personal Information Starts -->
														<div class="form-group row">
															<label for="inputFname"
																class="col-sm-3 col-form-label text-right">이 름 :</label>
															<div class="col-sm-9">
																<input type="text" class="form-control" name="name"
																	placeholder="${authUser.name }">
															</div>
														</div>
														<div class="form-group row">
															<label for="inputCurPassword"
																class="col-sm-3 col-form-label text-right">비밀번호
																:</label>
															<div class="col-sm-9">
																<input type="text" class="form-control" name="curPwd"
																	placeholder="비밀번호">
																<c:if test="${errors.badCurPwd}">현재 암호가 일치하지 않습니다.</c:if>
															</div>
														</div>
														<div class="form-group row">
															<label for="inputNewPassword"
																class="col-sm-3 col-form-label text-right">새비밀번호
																:</label>
															<div class="col-sm-9">
																<input type="text" class="form-control" name="newPwd"
																	placeholder="새비밀번호">
																<c:if test="${errors.newPwd}">새 암호를 입력하세요.</c:if>
															</div>
														</div>
														<div class="form-group row">
															<label for="inputNickName"
																class="col-sm-3 col-form-label text-right">닉네임 :</label>
															<div class="col-sm-9">
																<input type="text" class="form-control" name="NickName"
																	placeholder="닉네임">
															</div>
														</div>
														<div class="form-group row">
															<label for="inputBirth"
																class="col-sm-3 col-form-label text-right">생 일 :</label>
															<div class="col-sm-9">
																<input type="text" class="form-control" name="Birth"
																	placeholder="Birth">
															</div>
														</div>
														<div class="form-group row">
															<label for="inputEmail"
																class="col-sm-3 col-form-label text-right">Email
																:</label>
															<div class="col-sm-9">
																<input type="email" class="form-control" id="inputEmail"
																	placeholder="Email">
															</div>
														</div>
														<div class="form-group row">
															<label for="inputGender"
																class="col-sm-3 col-form-label text-right">성 별 :</label>
															<div class="col-sm-9">
																<input type="text" class="form-control" name="Gender"
																	placeholder="성별">
															</div>
														</div>

														<div class="form-group row">

															<button type="submit"
																class="btn btn-block btn-prime animation">
																저장 <i class="fa fa-caret-right"></i>
															</button>

														</div>
														<!-- Personal Information Ends -->
													</form>
												</div>
											</div>
										</div>
									</div>
								</section>
							</div>
							<!-- Left Column Ends -->
						</div>
						<!-- Tab #1 Nested Row Ends -->
					</div>
					<!-- Tab #1 Ends -->
					<!-- Tab #2 Starts -->
					<div id="information" class="tab-pane fade">
						<!-- Tab #2 Nested Row Starts -->
						<div class="row">
							<!-- Left Column Starts -->
							<div class="col-md-4 col-sm-12">
								<div class="side-block-1">
									<h6>Delivery Menu</h6>
									<ul class="list-unstyled list-style-2">
										<li>Soups</li>
										<li>Southern Grills: Veg.</li>
										<li>Southern Grills: Non-Veg.</li>
										<li>Starters</li>
										<li>Chinese Starters</li>
										<li>North Indian Main Course</li>
										<li>Traditional Telugu Maincourse</li>
										<li>Indian Breads</li>
										<li>Rice, Biryani &amp; Pulao</li>
										<li>Accompaniments</li>
										<li>Desserts &amp; Beverages</li>
									</ul>
								</div>
							</div>
							<!-- Left Column Ends -->
							<!-- Right Column Starts -->
							<div class="col-md-8 col-sm-12">
								<!-- Information Tab Pane Starts -->
								<div class="information-tab-pane">
									<p class="text-center">
										<img src="images/banners/banner-discount.png"
											alt="Discount Banner" class="img-fluid">
									</p>
									<!-- Spacer Starts -->
									<div class="spacer big"></div>
									<!-- Spacer Ends -->
									<p>Check out the $20 menu any drink or
										snack.........Cheers.</p>
									<p>Bring your friends along &amp; party hard.</p>
									<p>Spread the word - Food and Drinks at $20 bucks! Between
										4.00 to 8.00 pm Last order @ 7.45 pm Club rules apply. Dress
										code mandatory.</p>
									<p>Restaurants are solely responsible for the service;
										availability and quality of the events including all or any
										cancellations/ modifications/ complaints.</p>
									<hr>
									<!-- Delivery Hours Starts -->
									<h6>
										<i class="fa fa-clock-o"></i> Delivery Hours
									</h6>
									<ul class="list-unstyled timing-list">
										<li class="clearfix"><span class="float-left">Monday</span>
											<span class="float-right text-right">12:00 - 15:30,
												18:00 - 22:30</span></li>
										<li class="clearfix"><span class="float-left">Tuesday</span>
											<span class="float-right text-right">12:00 - 15:30,
												18:00 - 22:30</span></li>
										<li class="clearfix"><span class="float-left">Wednesday</span>
											<span class="float-right text-right">12:00 - 15:30,
												18:00 - 22:30</span></li>
										<li class="clearfix"><span class="float-left">Thursday</span>
											<span class="float-right text-right">12:00 - 15:30,
												18:00 - 22:30</span></li>
										<li class="clearfix"><span class="float-left">Friday</span>
											<span class="float-right text-right">12:00 - 15:30,
												18:00 - 22:30</span></li>
										<li class="clearfix"><span class="float-left">Saturday</span>
											<span class="float-right text-right">12:00 - 15:30,
												18:00 - 22:30</span></li>
										<li class="clearfix"><span class="float-left">Sunday</span>
											<span class="float-right text-right">12:00 - 15:30,
												18:00 - 22:30</span></li>
									</ul>
									<!-- Delivery Hours Ends -->
									<hr>
									<!-- Takeway Hours Starts -->
									<h6>
										<i class="fa fa-clock-o"></i> Takeway Hours
									</h6>
									<ul class="list-unstyled timing-list">
										<li class="clearfix"><span class="float-left">Monday</span>
											<span class="float-right text-right">12:00 - 15:30,
												18:00 - 22:30</span></li>
										<li class="clearfix"><span class="float-left">Tuesday</span>
											<span class="float-right text-right">12:00 - 15:30,
												18:00 - 22:30</span></li>
										<li class="clearfix"><span class="float-left">Wednesday</span>
											<span class="float-right text-right">12:00 - 15:30,
												18:00 - 22:30</span></li>
										<li class="clearfix"><span class="float-left">Thursday</span>
											<span class="float-right text-right">12:00 - 15:30,
												18:00 - 22:30</span></li>
										<li class="clearfix"><span class="float-left">Friday</span>
											<span class="float-right text-right">12:00 - 15:30,
												18:00 - 22:30</span></li>
										<li class="clearfix"><span class="float-left">Saturday</span>
											<span class="float-right text-right">12:00 - 15:30,
												18:00 - 22:30</span></li>
										<li class="clearfix"><span class="float-left">Sunday</span>
											<span class="float-right text-right">12:00 - 15:30,
												18:00 - 22:30</span></li>
									</ul>
									<!-- Takeway Hours Ends -->
									<hr>
									<!-- Spacer Starts -->
									<div class="spacer"></div>
									<!-- Spacer Ends -->
									<!-- Banners Starts -->
									<div class="row text-center">
										<div class="col-6">
											<img src="images/banners/banner-img1.png" alt="Banner 1"
												class="img-fluid">
										</div>
										<div class="col-6">
											<img src="images/banners/banner-img2.png" alt="Banner 2"
												class="img-fluid">
										</div>
									</div>
									<!-- Banners Ends -->
								</div>
								<!-- Information Tab Pane Ends -->
							</div>
							<!-- Right Column Ends -->
						</div>
						<!-- Tab #2 Nested Row Ends -->
					</div>
					<!-- Tab #2 Ends -->
					<!-- Tab #3 Starts -->
					<div id="gallery" class="tab-pane fade">
						<!-- Image Gallery Starts -->
						<ul class="row list-unstyled gallery-grid">
							<!-- Gallery Image #1 Starts -->
							<li class="col-md-4 col-sm-6">
								<div class="hover-content text-center">
									<img src="images/gallery/thumb/gallery-thumb-img1.jpg"
										alt="Gallery Image" class="img-fluid">
									<div class="overlay animation">
										<a href="images/gallery/big/gallery-big-img1.jpg"
											class="btn btn-link zoom"><i class="fa fa-search-plus"></i></a>
									</div>
								</div>
							</li>
							<!-- Gallery Image #1 Ends -->
						</ul>
						<!-- Image Gallery Ends -->
					</div>
					<!-- Tab #3 Ends -->
					<!-- Tab #4 Starts -->
					<div id="reviews" class="tab-pane fade">
						<!-- Tab #4 Nested Row Starts -->
						<div class="row">
							<!-- Right Column Starts -->
							<div class="col-md-8 col-sm-12">
								<!-- Reviews Tab Pane Starts -->
								<div class="reviews-tab-pane">
									<!-- Menu Tabs Content Ends -->
								</div>
								<!-- Menu Tabs Ends -->
							</div>
							<!-- Mainarea Ends -->
							<!-- Sidearea Starts -->
							<div class="col-md-3 col-sm-12">
								<!-- Spacer Starts -->
								<div class="spacer-1 medium d-xs-block d-sm-block d-md-none"></div>
								<!-- Spacer Ends -->

							</div>
							<!-- Sidearea Ends -->
						</div>
						<!-- Nested Row Ends -->
					</div>
					<!-- Main Container Ends -->

					<%@ include file="../include/footer.jspf"%>