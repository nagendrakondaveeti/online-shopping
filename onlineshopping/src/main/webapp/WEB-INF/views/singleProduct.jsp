<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container">
	<!-- bread crumb -->

	<div class="row">
		<div class="col-xs-12">

			<ol class="breadcrumb">
				<li><a href="${contextRoot}/home">Home&nbsp;&nbsp;</a></li>
				<li><a href="${contextRoot}/show/all/products">Products&nbsp;&nbsp;</a></li>
				<li class="active">${product.name}</li>

			</ol>
		</div>

	</div>
	<div class="row">
	<!-- display the product image -->
	<div class="col-xs-12 col-sm-4">
	<div class="thumbnail">
		<img src="${images}/${product.code}.jpg" class="img img-responsive"/>
		
	</div>
	
	</div>
	
	<!-- Display the product  description -->
	<div class="col-xs-12 col-sm-8">
		<h3>${product.name}</h3>
		<hr/>
		<p>${product.description}</p>
		<hr/>
		<h4>Price:<strong>&#8377; ${product.unitPrice} /-</strong></h4>
		<hr/>
		
		<c:choose>
			
			<c:when test="${product.quantity < 1}">
			<h6>Qty.available:<span style="color:red">Out of Stock!</span></h6>
			</c:when>
			<c:otherwise>
			<h6>Qty. Available: ${product.quantity}</h6>
			</c:otherwise>
		</c:choose>
		
		
		<c:choose>
			
			<c:when test="${product.quantity < 1}">
			<a href="javascript:void(0)" class="btn btn-success disabled"> <strike><span class="glyphicon glyphicon-shopping-cart"></span>Add To Cart</strike></a>
			</c:when>
			<c:otherwise>
			<a href="${contextRoot}/cart/add/${product.id}/product" class="btn btn-success"> <span class="glyphicon glyphicon-shopping-cart"></span>Add To Cart</a>
			</c:otherwise>
		</c:choose>
		
		
		
		<a href="${contextRoot}/show/all/products" class="btn btn-success"> Back</a>
		
	
	</div>
	
	</div>
</div>