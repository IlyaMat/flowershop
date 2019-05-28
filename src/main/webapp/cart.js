$(document).ready(function () {

    var $addCartItemButtons = $('[role=addCartItem]');
    var quantity = $('input[name="quantity"]').val();
     //var quantity = document.forms["addToCart"]["quantity"].value;



     $addCartItemButtons.each(function () {
            var productId = $(this).attr('data-id');
            //var quantity = $(this).attr('data-atr');

            $(this).on('click', function () {
                $.ajax({
                   type: "POST",
                   url: '/rest/shoppingcart/add',
                   contentType: "application/json; charset=utf-8",
                   data: JSON.stringify({productId: productId, quantity:quantity}),
                   dataType: "json",

                }).done(function (data) {
                    refreshCartFields.call(this, data);
                })
            });
        })


});
