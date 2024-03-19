1.) User -> OrderService
order is created

2.) User -> PaymentService
create payment link:
paymentService -> orderService
gets the amount of order, etc, etc
creates a payment link for that order

3.) User -> Payment Link
make the payment etc etc
user gets redirected to the callback url

4.) CallBack -> PaymentService
check the status of Payment

5.) PaymentGateway -> PaymentService
webhook URL


PaymentService
- createPaymentLink
- getPaymentStatus
- handleWebhookEvent