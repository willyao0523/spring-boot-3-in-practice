import React, {useState} from "react";


export default  function NewVideo() {
    const [name, setName] = useState("")

    const handleSubmit = async (e) => {
        e.preventDefault()

        try {
            await fetch("/api/videos", {
                method: "POST",
                headers: {
                    "Content-type": "application/json"
                },
                body: JSON.stringify({
                    name
                })
            })
            window.location.href = "/react"
        } catch (e) {
            console.log(e)
        }
    }

    const handleChange = (e) => {
        setName(e.target.value)
    }

    return (
        <form onSubmit={handleSubmit}>
            <input type="text" value={name} onChange={handleChange} />
            <button type="submit">Submit</button>
        </form>
    )
}