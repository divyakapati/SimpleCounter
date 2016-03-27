$(document)
		.ready(
				function() {

					var cart = [];
					var cartIndex = 0;
					var selectedItem = undefined;

					function updateTotalCounter() {
						var price = 0;
						var counter = 0;
						var quantity = 0;
						for ( var key in cart) {
							var item = cart[key];
							console.log("Item ", item);
							counter++;
							price = (parseFloat(price) + parseFloat(item.total))
									.toFixed(2);
							quantity += parseInt(item.quantity);
						}
						$(".itemsControl").html("Total Items: " + counter);
						$(".qtyControl").html("Total Qty: " + quantity);
						$(".costControl").html("Total Cost: " + price);

					}

					$(document).on("click", ".deleteControl", function() {
						var spanTag = $('span:first', this);
						console.log("The span was obtained", $(spanTag));
						var id = spanTag.attr("id");
						$(this).parent().remove();
						delete cart[id];
						updateTotalCounter();
					});

					$("#search")
							.autocomplete(
									{
										source : function(request, response) {
											console.log("Request and Response",
													request, response);
											jQuery
													.get(
															"/rest/counter/product/lookup/",
															{
																query : request.term
															},
															function(data) {
																console
																		.log(
																				"Data obtained from this search term",
																				data);
																response(data);
															});

										},
										minLength : 2,
										select : function(event, ui) {
											selectedItem = ui.item;
										}

									});

					$("#add")
							.click(
									function() {
										var product = $("#search").val();
										var quantity = $("#quantity").val();
										if (!product || !quantity) {
											alert("Please select both product and quantity.");
											return;
										}
										if (product == selectedItem.name
												|| product == selectedItem.code) {
											var entry = $.extend({},
													selectedItem);
											var totalPrice = (entry.price + entry.taxAmount)
													* quantity;

											entry.quantity = quantity;
											entry.total = totalPrice.toFixed(2);

											var cartId = "cart-" + cartIndex++;
											cart[cartId] = entry;
											$("#tblData tbody")
													.append(
															"<tr>"
																	+ "<td>"
																	+ entry.name
																	+ "</td>"
																	+ "<td>"
																	+ entry.quantity
																	+ "</td>"
																	+ "<td>"
																	+ entry.price
																	+ "</td>"
																	+ "<td>"
																	+ entry.taxAmount
																	+ " ("
																	+ entry.category.tax
																	+ "%)</td>"
																	+ "<td>"
																	+ entry.total
																	+ "</td>"
																	+ "<td class='deleteControl'><span id='"
																	+ cartId
																	+ "' class='ui-icon ui-icon-circle-close ' style='display:inline-block'></span></td>"
																	+ "</tr>");

										}

										updateTotalCounter();
									});

				});
