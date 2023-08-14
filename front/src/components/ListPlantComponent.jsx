import React, { useEffect, useState } from 'react'
import { deletePlant, getAllPlants } from '../services/PlantsService.js'
import { useNavigate } from 'react-router-dom'

const ListPlantComponent = () => {

    const [plants, setPlants] = useState([])

    const navigate = useNavigate()


    useEffect(() => {
        listPlants();
    }, [])
    
    function listPlants(){
        getAllPlants().then((response) => {
            setPlants(response.data);
        }).catch(error => {
            console.error(error);
        })
    }

    function addNewPlant(){
        navigate('/add-plant')

    }

    function updatePlant(id){
        console.log(id)
        navigate(`/update-plant/${id}`)
    }
    
    function removePlant(id){
        deletePlant(id).then((response) => {
            listPlants();
        }).catch(error => {
            console.error(error)
        })
    }

    // function markCompleteTodo(id){
    //     completeTodo(id).then((response) => {
    //         listTodos()
    //     }).catch(error => {
    //         console.error(error)
    //     })
    // }
    //
    // function markInCompleteTodo(id){
    //     inCompleteTodo(id).then((response) => {
    //         listTodos();
    //     }).catch(error => {
    //         console.error(error)
    //     })
    // }

  return (
    <div className='container'>
        <h2 className='text-center'>List of Plants</h2>
        <button className='btn btn-primary mb-2' onClick={addNewPlant}>Add Plant</button>
        <div>
            <table className='table table-bordered table-striped'>
                <thead>
                    <tr>
                        <th>Plant Name</th>
                        <th>Plant Description</th>
                        <th>Plant  Image</th>
                        <th>Plant Scientific Name</th>
                        <th>Plant Family</th>
                        <th>Plant Drying Level</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                    {
                        plants.map(plant =>
                            <tr key={plant.id}>
                                <td>{plant.name}</td>
                                <td>{plant.description}</td>
                                <td>{plant.image}</td>
                                <td>{plant.scientificName}</td>
                                <td>{plant.family}</td>
                                <td>{plant.plantsDryingLevel}</td>
                                {/*<td>{plant.completed ? 'YES': 'NO'}</td>*/}
                                <td>
                                    <button className='btn btn-info' onClick={() => updatePlant(plant.id)}>Update</button>
                                    <button className='btn btn-danger' onClick={() => removePlant(plant.id)} style={ { marginLeft: "10px" }} >Delete</button>
                                    {/*<button className='btn btn-success' onClick={() => markCompletePlant(plant.id)} style={ { marginLeft: "10px" }} >Complete</button>*/}
                                    {/*<button className='btn btn-info' onClick={() => markInCompletePlant(plant.id)} style={ { marginLeft: "10px" }} >InComplete</button>*/}
                                </td>
                            </tr>
                        )
                    }

                </tbody>
            </table>
        </div>

    </div>
  )
}

export default ListPlantComponent