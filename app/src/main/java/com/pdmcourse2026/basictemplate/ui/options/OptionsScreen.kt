package com.pdmcourse2026.basictemplate.ui.options

import android.annotation.SuppressLint

class OptionsScreen {
    @SuppressLint("NotConstructor")
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun OptionsScreen(
        questionId: Int,
        viewModel: OptionsViewModel = viewModel(
            factory = OptionsViewModel.provideFactory(questionId)
        )
    ) {
        val options by viewModel.options.collectAsStateWithLifecycle()
        var showSheet by rememberSaveable { mutableStateOf(false) }

        Scaffold(
            containerColor = MaterialTheme.colorScheme.surfaceContainerLowest,
            topBar = {
                TopAppBar(
                    title = { Text("Administrar opciones") },
                    actions = {
                        TextButton(onClick = { showSheet = true }) {
                            Icon(imageVector = Icons.Default.Add, contentDescription = "Nueva opción")
                            Spacer(modifier = Modifier.width(4.dp))
                            Text("Nuevo")
                        }
                    },
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = MaterialTheme.colorScheme.surface
                    )
                )
            }
        ) { innerPadding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
                    .padding(horizontal = 16.dp, vertical = 12.dp)
            ) {

                if (options.isEmpty()) {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Icon(
                            imageVector = Icons.Default.Inbox,
                            contentDescription = null,
                            tint = MaterialTheme.colorScheme.outline,
                            modifier = Modifier.height(36.dp)
                        )
                        Spacer(modifier = Modifier.height(12.dp))
                        Text(
                            text = "Todavia no hay opciones",
                            style = MaterialTheme.typography.titleMedium
                        )
                        Text(
                            text = "Toca Nuevo para crear la primera.",
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                } else {
                    LazyColumn(
                        modifier = Modifier.fillMaxSize(),
                        contentPadding = PaddingValues(vertical = 4.dp),
                        verticalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        items(items = options, key = { it.id }) { option ->
                            ElevatedCard {
                                ListItem(
                                    headlineContent = {
                                        Text(
                                            text = option.name,
                                            style = MaterialTheme.typography.titleMedium
                                        )
                                    },
                                    supportingContent = {
                                        Text(
                                            text = option.imageUrl,
                                            style = MaterialTheme.typography.bodySmall,
                                            color = MaterialTheme.colorScheme.onSurfaceVariant
                                        )
                                    },
                                    trailingContent = {
                                        IconButton(onClick = { viewModel.deleteOption(option) }) {
                                            Icon(
                                                imageVector = Icons.Default.DeleteOutline,
                                                contentDescription = "Borrar ${option.name}",
                                                tint = MaterialTheme.colorScheme.error
                                            )
                                        }
                                    }
                                )
                            }
                        }
                    }
                }
            }
        }

        if (showSheet) {
            OptionBottomSheet(
                onSave = { name, imageUrl ->
                    viewModel.addOption(name, imageUrl)
                },
                onDismiss = { showSheet = false }
            )
        }
    }