<html>
<head>

<link href="/css/bootstrap.css" rel="stylesheet" />
<link href="/css/bootstrap-theme.css" rel="stylesheet" />
<link href="/css/jquery-ui.css" rel="stylesheet" />
<link href="/css/app.css" rel="stylesheet" />
</head>
<body>
	<div class="example-counter">

		<div>
			<h1>Checkout Counter Example</h1>
		</div>
		<div class="row">
			<div class="col-md-3">
				<div class="panel panel-default">
					<div class="panel-heading">Product Scanner</div>
					<div class="panel-body">
						<div class="row">
							<div class="col-md-3">
								<label for="search">Item Code</label>
							</div>
							<div class="col-md-9">
								&nbsp;:<input class="wide" id="search">
							</div>
						</div>

						<div class="row spacer">
							<div class="col-md-3">
								<label for="search">Quantity</label>
							</div>
							<div class="col-md-9">
								&nbsp;:<input class="wide" id="quantity" value="1">
							</div>
						</div>

						<div class="row spacer">
							<div class="col-md-3">
								<input type="button" value="Add" id="add" />
							</div>

						</div>
					</div>
				</div>
			</div>
			<div class="col-md-9">
				<div class="panel panel-default">
					<div class="panel-heading">Billing</div>
					<div class="panel-body">
						<div class="row">
							<table id="tblData" class="table table-condensed table-hover">
								<thead>
									<tr>
										<th>Item</th>
										<th>Qty</th>
										<th>Price</th>
										<th>Tax</th>
										<th>Total</th>
									</tr>
								</thead>
								<tbody>
								</tbody>
							</table>
						</div>
						<div class="row">
							<div class="col-md-4 itemsControl">Total Items: 0</div>
							<div class="col-md-4 qtyControl">Total Qty: 0</div>
							<div class="col-md-4 costControl">Total Cost: 0</div>
						</div>

					</div>
				</div>
			</div>

		</div>
	</div>

	<script src="/js/jquery-1.12.2.min.js" type="text/javascript"></script>
	<script src="/js/jquery-ui.min.js" type="text/javascript"></script>
	<script src="/js/app.js" type="text/javascript"></script>
</body>
</html>
