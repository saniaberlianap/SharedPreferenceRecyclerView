<?php
include("config.php");

$nama_mahasiswa = $_POST['nama_mahasiswa'];
$nomor_mahasiswa = $_POST['nomor_mahasiswa'];
$alamat_mahasiswa = $_POST['alamat_mahasiswa'];


	$sql = "INSERT INTO mahasiswa ( nama_mahasiswa, nomor_mahasiswa, alamat_mahasiswa ) VALUES ('$nama_mahasiswa', '$nomor_mahasiswa', '$alamat_mahasiswa')";
	$query = mysqli_query($db, $sql);

if($query){
    echo json_encode(array('message'=>'student data successfully added.'));
  }else{
    echo json_encode(array('message'=>'student data failed to add.'));
  }

?>