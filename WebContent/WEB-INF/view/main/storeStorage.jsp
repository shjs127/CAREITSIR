<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../include/header.jspf"%>
    
            <!-- Main Heading Starts -->
            <h2 class="main-heading text-center">
                매장 정보 신청서 <br />
            </h2>
        <!-- Main Heading Ends -->
        <!-- Registration Section Starts -->
            <section class="registration-area">
                <div class="row">
                    <div class="col-sm-6">
                    <!-- Registration Block Starts -->
                        <div class="panel panel-smart">
                            <div class="panel-heading">
                                <h3 class="panel-title">매장 정보</h3>
                            </div>
                            <div class="panel-body">
                            <!-- Registration Form Starts -->
                                <form>
                                <!-- Personal Information Starts -->
                                    <div class="form-group row">
                                        <label for="inputFname" class="col-sm-3 col-form-label text-right">매장명 :</label>
                                        <div class="col-sm-9">
                                            <input type="text" class="form-control" id="inputFname" placeholder="매장명">
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <label for="inputLname" class="col-sm-3 col-form-label text-right">주소 :</label>
                                        <div class="col-sm-9">
                                            <input type="text" class="form-control" id="inputLname" placeholder="주소">
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <label for="inputEmail" class="col-sm-3 col-form-label text-right">영업시간 :</label>
                                        <div class="col-sm-9">
                                            <input type="text" class="form-control" id="inputEmail" placeholder="영업시간">
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <label for="inputPhone" class="col-sm-3 col-form-label text-right">휴무일 :</label>
                                        <div class="col-sm-9">
                                            <input type="text" class="form-control" id="inputPhone" placeholder="휴무일">
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <label for="inputFax" class="col-sm-3 col-form-label text-right">전화번호 :</label>
                                        <div class="col-sm-9">
                                            <input type="text" class="form-control" id="inputFax" placeholder="전화번호">
                                        </div>
                                    </div>
                                <!-- Personal Information Ends -->
                                    <h3 class="panel-heading inner">
                                        상세 정보
                                    </h3>
                                <!-- Delivery Information Starts -->
                                    <div class="form-group row">
                                        <label for="inputCompany" class="col-sm-3 col-form-label text-right">총 테이블 수:</label>
                                        <div class="col-sm-9">
                                            <input type="text" class="form-control" id="inputCompany" placeholder="총 테이블 수">
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <label for="inputCompanyId" class="col-sm-3 col-form-label text-right">콘센트 사용 가능 테이블 수 :</label>
                                        <div class="col-sm-9">
                                            <input type="text" class="form-control" id="inputCompanyId" placeholder="콘센트 사용 가능 테이블 수">
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <label for="inputAddress1" class="col-sm-3 col-form-label text-right">디저트 판매 여부 :</label>
                                        <div class="col-sm-9">
                                            <input type="radio" class="form-control" id="inputAddress1"><label>Y</label>
                                            <input type="radio" class="form-control" id="inputAddress1"><label>N</label>
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <label for="inputAddress2" class="col-sm-3 col-form-label text-right">Address/2 :</label>
                                        <div class="col-sm-9">
                                            <input type="text" class="form-control" id="inputAddress2" placeholder="Address/2">
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <label for="inputCity" class="col-sm-3 col-form-label text-right">City :</label>
                                        <div class="col-sm-9">
                                            <input type="text" class="form-control" id="inputCity" placeholder="City">
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <label for="inputPostCode" class="col-sm-3 col-form-label text-right">Postal Code :</label>
                                        <div class="col-sm-9">
                                            <input type="text" class="form-control" id="inputPostCode" placeholder="Postal Code">
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <label for="inputCountry" class="col-sm-3 col-form-label text-right">Country :</label>
                                        <div class="col-sm-9">
                                            <select class="form-control" id="inputCountry">
                                                <option>- All Countries -</option>
                                                <option>India</option>
                                                <option>USA</option>
                                                <option>UK</option>
                                                <option>China</option>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <label for="inputRegion" class="col-sm-3 col-form-label text-right">Region :</label>
                                        <div class="col-sm-9">
                                            <select class="form-control" id="inputRegion">
                                                <option>- All Regions -</option>
                                            </select>
                                        </div>
                                    </div>
                                <!-- Delivery Information Ends -->
                                    <h3 class="panel-heading inner">
                                        Password
                                    </h3>
                                <!-- Password Area Starts -->
                                    <div class="form-group row">
                                        <label for="inputPassword" class="col-sm-3 col-form-label text-right">Password :</label>
                                        <div class="col-sm-9">
                                            <input type="password" class="form-control" id="inputPassword" placeholder="Password">
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <label for="inputRePassword" class="col-sm-3 col-form-label text-right">Re-Password :</label>
                                        <div class="col-sm-9">
                                            <input type="password" class="form-control" id="inputRePassword" placeholder="Re-Password">
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <span class="col-sm-3 col-form-label text-right">Newsletter :</span>
                                        <div class="col-sm-9">
                                            <div class="radio">
                                                <label>
                                                    <input type="radio" name="optionsRadios" id="optionsRadios1" value="option1" checked>
                                                    Subscribe
                                                </label>
                                            </div>
                                            <div class="radio">
                                                <label>
                                                    <input type="radio" name="optionsRadios" id="optionsRadios2" value="option1">
                                                    Unsubscribe
                                                </label>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <div class="offset-sm-3 col-sm-9">
                                            <div class="checkbox">
                                                <label>
                                                    <input type="checkbox"> I'v read and agreed on Conditions
                                                </label>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <div class="offset-sm-3 col-sm-9">
                                            <button type="submit" class="btn btn-black">
                                                Register
                                            </button>
                                        </div>
                                    </div>
                                <!-- Password Area Ends -->
                                </form>
                            <!-- Registration Form Starts -->
                            </div>							
                        </div>
                    <!-- Registration Block Ends -->
                    </div>
                    <div class="col-sm-6">
                    <!-- Guest Checkout Panel Starts -->
                        <div class="panel panel-smart">
                            <div class="panel-heading">
                                <h3 class="panel-title">
                                    Checkout as Guest
                                </h3>
                            </div>
                            <div class="panel-body">
                                <p>
                                    Checkout as a guest instead!
                                </p>
                                <button class="btn btn-black">As Guest</button>
                            </div>
                        </div>
                    <!-- Guest Checkout Panel Ends -->
                    <!-- Conditions Panel Starts -->
                        <div class="panel panel-smart">
                            <div class="panel-heading">
                                <h3 class="panel-title">
                                    Conditions
                                </h3>
                            </div>
                            <div class="panel-body">
                                <p>
                                    Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including  versions of Lorem Ipsum.
                                </p>
                                <ol>
                                <li>Lorem ipsum dolor sit amet</li>
                                <li>Consectetur adipiscing elit</li>
                                <li>Integer molestie lorem at massa</li>
                                <li>Facilisis in pretium nisl aliquet</li>
                                <li>Nulla volutpat aliquam velit</li>
                                <li>Faucibus porta lacus fringilla vel</li>
                                <li>Aenean sit amet erat nunc</li>
                                <li>Eget porttitor lorem</li>
                                </ol>
                                <p>
                                    HTML Nullam varius, turpis et commodo pharetra, est eros bibendum elit, nec luctus magna felis sollicitudin mauris. 
                                </p>
                                <p>
                                    Integer in mauris eu nibh euismod gravida. Duis ac tellus et risus vulputate vehicula. Donec lobortis risus a elit. Etiam tempor. Ut ullamcorper, ligula eu tempor congue, eros est euismod turpis, id tincidunt sapien risus a quam. Maecenas fermentum consequat mi. Donec fermentum. Pellentesque malesuada nulla a mi. Duis sapien sem, aliquet nec, commodo eget, consequat quis, neque. 
                                </p>
                                <p>
                                    Aliquam faucibus, elit ut dictum aliquet, felis nisl adipiscing sapien, sed malesuada diam lacus eget erat. Cras mollis scelerisque nunc. Nullam arcu. Aliquam consequat. Curabitur augue lorem, dapibus quis, laoreet et, pretium ac, nisi. 
                                </p>
                                <p>
                                    Aenean magna nisl, mollis quis, molestie eu, feugiat in, orci. In hac habitasse platea dictumst. 
                                </p>
                            </div>
                        </div>
                    <!-- Conditions Panel Ends -->
                    </div>
                </div>
            </section>
        <!-- Registration Section Ends -->
		</div>
	<!-- Main Container Ends -->
	
	<%@ include file="../include/footer.jspf"%>