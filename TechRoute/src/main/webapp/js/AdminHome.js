document.addEventListener("DOMContentLoaded", function () {
      axios("http://localhost:8080/TechRoute/getNotifications")
        .then(function (response) {
          const count = response.data;

          const badge = document.getElementById("notificationCount");
          badge.textContent = count;
          badge.style.display = count > 0 ? "inline-block" : "none";
        })
        .catch(function (error) {
          console.error("Failed to fetch notifications:", error);
        });
});
document.getElementById("notificationsModel").addEventListener("show.bs.modal", async function () {
    try {
        const response = await axios.get("http://localhost:8080/TechRoute/viewPendingOrders");
        const orders = response.data;
        const container = document.getElementById("notificationsContainer");
        container.innerHTML = "";
        if (!orders || orders.length === 0) {
            container.innerHTML = "<p class='text-muted'>No pending orders.</p>";
            return;
        }

        orders.forEach(order => {
            const orderElement = document.createElement("div");
            orderElement.className = "border-bottom py-2";

            orderElement.innerHTML = `
                <div class="d-flex justify-content-between align-items-start flex-wrap">
                    <div class="me-3">
                        <strong>Customer:</strong> ${order.customerName}<br>
                        <strong>Due Date:</strong> ${order.orderDueDate}<br>
                        <strong>Order Status:</strong> ${order.status}<br>
                    </div>
                        <a href="viewOrder?id=${order.id}" class="btn btn-sm btn-info mt-2" role="button" type="button">View</a>
                </div>
            `;
            container.appendChild(orderElement);
        });
    } catch (error) {
        console.error("Error fetching orders:", error);
        document.getElementById("notificationsContainer").innerHTML = "<p class='text-danger'>Failed to load notifications.</p>";
    }
});


