package com.aman.fakestorecom.screens


//@Composable
//fun DisplayCategory(
//    viewModel: CategoryViewModel = hiltViewModel()
//) {
//    val categories = viewModel.categories.collectAsState().value
//    var expanded by remember { mutableStateOf(false) }
//    var selectedCategory by remember { mutableStateOf<String?>(null) }
//    Column {
//        Spacer(modifier = Modifier.padding(40.dp))
//        Text(text = selectedCategory?: "Select a Category",
//            modifier = Modifier
//                .fillMaxWidth()
//                .clickable { expanded = true }
//                .padding(16.dp)
//        )
//        DropdownMenu(
//            expanded = expanded ,
//            onDismissRequest = { expanded = false }) {
//            categories.forEach{ category ->
//            DropdownMenuItem(
//                onClick = {
//                    selectedCategory = category
//                    expanded = false
//                },
//                text = {
//                    Text(
//                        text = category,
//                        color = Color.Black // Set the text color to black
//                    )
//                }
//            )
//            }
//
//        }
//
//    }
//
//}