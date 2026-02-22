document.addEventListener("DOMContentLoaded", function() {
    console.log("Sistema de Gestión Académica Cargado Correctamente.");
});

// funcion para confirmar la eliminacion de un registro
function confirmarEliminacion(event) {
    if (!confirm("¿Está seguro de que desea eliminar este registro? Esta acción no se puede deshacer.")) {
        event.preventDefault(); // detiene la navegacion si el usuario cancela
    }
}

// animación básica GSAP 
if (typeof gsap !== "undefined") {
    gsap.from(".card", {
        y: 20,
        opacity: 0,
        duration: 0.5,
        stagger: 0.1,
        ease: "power2.out"
    });
}