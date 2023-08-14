import React, { useEffect } from 'react'
import { useState } from 'react'
import { getPlant, savePlant, updatePlant } from '../services/PlantsService.js'
import { useNavigate, useParams } from 'react-router-dom'

const PlantComponent = () => {


    const [name, setName] = useState('')
    const [description, setDescription] = useState('')
    const [image, setImage] = useState('')
    const [scientificName, setScientificName] = useState('')
    const [family, setFamily] = useState('')
    const [plantsDryingLevel, setPlantsDryingLevel] = useState('')
    const navigate = useNavigate()
    const { id } = useParams()


    function saveOrUpdatePlant(e){
        e.preventDefault()

        const plant = {name, description, image, scientificName, family, plantsDryingLevel}
        console.log(plant);

        if(id){

            updatePlant(id, plant).then((response) => {
                navigate('/plants')
            }).catch(error => {
                console.error(error);
            })

        }else{
            savePlant(plant).then((response) => {
                console.log(response.data)
                navigate('/plants')
            }).catch(error => {
                console.error(error);
            })
        }
    }

    function pageTitle(){
        if(id) {
            return <h2 className='text-center'>Update Plant</h2>
        }else {
            return <h2 className='text-center'>Add Plant</h2>
        }
    }

    useEffect( () => {

        if(id){
            getPlant(id).then((response) => {
                console.log(response.data)
                  const plant = response.data
                    setName(plant.name)
                    setDescription(plant.description)
                    setImage(plant.image)
                    setScientificName(plant.scientificName)
                    setFamily(plant.family)
                    setPlantsDryingLevel(plant.plantsDryingLevel)
            }).catch(error => {
                console.error(error);
            })
        }

    }, [id])

  return (
    <div className='container'>
        <br /> <br />
        <div className='row'>
            <div className='card col-md-6 offset-md-3 offset-md-3'>
                { pageTitle() }
                <div className='card-body'>
                    <form>
                        <div className='form-group mb-2'>
                            <label className='form-label'>Plant Name:</label>
                            <input
                                type='text'
                                className='form-control'
                                placeholder='Enter Plant Name'
                                name='Name'
                                value={name}
                                onChange={(e) => setName(e.target.value)}
                            >
                            </input>
                        </div>

                        <div className='form-group mb-2'>
                            <label className='form-label'>Plant Description:</label>
                            <input
                                type='text'
                                className='form-control'
                                placeholder='Enter Todo Description'
                                name='description'
                                value={description}
                                onChange={(e) => setDescription(e.target.value)}
                            >
                            </input>
                        </div>

                        <div className='form-group mb-2'>
                            <label className='form-label'>Plant Image:</label>
            <input
                                type='text'
                                className='form-control'
                                placeholder='Enter Image Url'
                                name='image'
                                value={image}
                                onChange={(e) => setImage(e.target.value)}
                            >
                            </input>
                        </div>

                        <div className='form-group mb-2'>
                            <label className='form-label'>Plant Scientific Name:</label>
                            <input
                                type='text'
                                className='form-control'
                                placeholder='Enter Scientific Name'
                                name='scientificName'
                                value={scientificName}
                                onChange={(e) => setScientificName(e.target.value)}
                            >
                            </input>

                        </div>

                        <div className='form-group mb-2'>
                            <label className='form-label'>Plant Family:</label>
                            <input
                                type='text'
                                className='form-control'
                                placeholder='Enter Family'
                                name='family'
                                value={family}
                                onChange={(e) => setFamily(e.target.value)}
                            >
                            </input>

                        </div>

                        <div className='form-group mb-2'>
                            <label className='form-label'>Plant Drying Level:</label>
                            <select
                                className='form-control'
                                name='platsDryingLevel'
                                value={plantsDryingLevel}
                                onChange={(e) => setPlantsDryingLevel(e.target.value)}
                            >
                                <option value=''>Select Drying Level</option>
                                <option value='LOW'>Low</option>
                                <option value='MEDIUM'>Medium</option>
                                <option value='HIGH'>High</option>
                            </select>
                        </div>

                        <button className='btn btn-success' onClick={ (e) => saveOrUpdatePlant(e)}>Submit</button>
                    </form>

                </div>
            </div>

        </div>
    </div>
  )
}

export default PlantComponent