import React, {useEffect, useState} from "react";

export default function ListOfVideos() {
    const [videos, setVideos] = useState([])
    useEffect(async () => {
        const data = await fetch("/api/videos")
        const jsonData = await data.json();
        setVideos(jsonData)
    }, [])

    return (
        <ul>
            {
                videos.map((video, key) => (
                    <li key={key}>
                        {video.name}
                    </li>
                ))
            }
        </ul>
    )
}