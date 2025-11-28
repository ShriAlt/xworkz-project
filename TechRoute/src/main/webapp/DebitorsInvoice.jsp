<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Invoice</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 24px; }
        h1 { text-align: center; }
        .section { margin-bottom: 20px; }
        table { width: 100%; border-collapse: collapse; margin-top: 20px; }
        th, td { border: 1px solid #333; padding: 8px; text-align: left; }
        .totals { margin-top: 20px; text-align: right; }
    </style>
</head>
<body>
<h1>INVOICE</h1>

<!-- Company Info -->
<div class="section">
    <strong>Company:</strong> ${order.companyName}<br/>
    <strong>Product Group:</strong> ${order.productGroupName}<br/>
    <strong>Product Code:</strong> ${order.productCode}
</div>

<!-- Customer Info (Admin is the customer here) -->
<div class="section">
    <strong>Customer:</strong> ${order.customerName} (Admin)<br/>
    <strong>Billing Address:</strong> TechRoute, Bengaluru, India<br/>
    <strong>Shipping Address:</strong> TechRoute, Bengaluru, India<br/>
    <strong>Order Due Date:</strong> ${order.orderDueDate}
</div>

<!-- Product Details -->
<table>
    <thead>
    <tr>
        <th>Model</th>
        <th>Quantity</th>
        <th>Unit Price</th>
        <th>Total</th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <td>${order.model}</td>
        <td>${order.quantity}</td>
        <td>${order.purchasePrice}</td>
        <td>${order.quantity * order.purchasePrice}</td>
    </tr>
    </tbody>
</table>

<!-- Totals -->
<div class="totals">
    <p>Subtotal: ${order.quantity * order.purchasePrice}</p>
    <p>Tax (18% GST): ${(order.quantity * order.purchasePrice) * 0.18}</p>
    <p><strong>Grand Total: ${(order.quantity * order.purchasePrice) * 1.18}</strong></p>
</div>

<p style="text-align:center; margin-top:40px;">Thank you for your business!</p>
</body>
</html>
